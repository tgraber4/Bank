package edu.missouri.csbank.bank.users;

import edu.missouri.csbank.bank.account.Account;
import edu.missouri.csbank.bank.account.AccountInfo;
import edu.missouri.csbank.bank.account.AccountType;
import edu.missouri.csbank.bank.account.OpenAccountRequest;
import edu.missouri.csbank.bank.repository.AccountRepository;
import edu.missouri.csbank.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/signup")
    public ResponseEntity<UserAuthResponse> signUp(@RequestBody SignUpRequest request) {
        UserAuthResponse response = new UserAuthResponse();

        if (userService.findByUsername(request.getUsername()).isPresent()) {
            response.setMessage("Username already exists.");
            response.setAuthorized(false);
            return ResponseEntity.badRequest().body(response);
        }

        PersonalInfo info = new PersonalInfo();
        info.setFirstName(request.getFirstName());
        info.setLastName(request.getLastName());
        info.setEmail(request.getEmail());

        User newUser = new User(request.getUsername(), request.getPassword(), info);
        userService.saveUser(newUser);

        response.setMessage("User created successfully!");
        response.setAuthorized(true);
        response.setResponseUUID(java.util.UUID.fromString(newUser.getId()));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthResponse> loginAuth(@RequestBody UserAuth auth) {
        UserAuthResponse response = new UserAuthResponse();

        Optional<User> userOpt = userService.findByUsername(auth.getUsername());
        
        if (userOpt.isEmpty()) {
            response.setMessage("User not found.");
            response.setAuthorized(false);
            return ResponseEntity.ok(response);
        }

        User user = userOpt.get();
        if (!userService.verifyPassword(user, auth.getPassword())) {
            response.setMessage("Incorrect Password.");
            response.setAuthorized(false);
            return ResponseEntity.ok(response);
        }

        response.setMessage("Success!");
        response.setAuthorized(true);
        response.setResponseUUID(java.util.UUID.fromString(user.getId()));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/user")
    public ResponseEntity<User> getUser(@RequestBody String uuid) {
        // Remove quotes if the frontend sends a quoted string
        String cleanUuid = uuid.replace("\"", "").trim();
        return userService.findById(cleanUuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/settings/update")
    public ResponseEntity<Void> updateSettings(@RequestBody java.util.Map<String, Object> payload) {
        String userId = (String) payload.get("userId");
        boolean transactionAlerts = (boolean) payload.get("transactionAlerts");
        boolean billAlerts = (boolean) payload.get("billAlerts");

        Optional<User> userOpt = userService.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setTransactionAlertsEnabled(transactionAlerts);
            user.setBillAlertsEnabled(billAlerts);
            userService.saveUser(user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody java.util.Map<String, String> payload) {
        String userId = payload.get("userId");
        String oldPassword = payload.get("oldPassword");
        String newPassword = payload.get("newPassword");

        Optional<User> userOpt = userService.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(oldPassword)) {
                user.setPassword(newPassword);
                userService.saveUser(user);
                return ResponseEntity.ok("Password changed successfully.");
            } else {
                return ResponseEntity.badRequest().body("Incorrect old password.");
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/openaccount")
    public ResponseEntity<Account> openAccount(@RequestBody OpenAccountRequest request) {
        Optional<User> userOpt = userService.findById(request.getUUID());
        
        if (userOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        User user = userOpt.get();
        AccountInfo info = AccountInfo.newAccountInfo(100.00);
        
        AccountType type;
        try {
            type = AccountType.valueOf(request.getAccountType().toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
        
        Account account = new Account(type, info);
        account.setNickname(request.getNickname() != null ? request.getNickname() : type.name());
        
        user.addAccount(account);
        userService.saveUser(user); // Cascades to save the account
        
        return ResponseEntity.ok(account);
    }
}