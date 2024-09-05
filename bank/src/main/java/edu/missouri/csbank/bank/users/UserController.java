package edu.missouri.csbank.bank.users;

import com.google.gson.Gson;
import edu.missouri.csbank.bank.account.Account;
import edu.missouri.csbank.bank.account.AccountInfo;
import edu.missouri.csbank.bank.account.AccountType;
import edu.missouri.csbank.bank.account.OpenAccountRequest;
import edu.missouri.csbank.bank.bankholder.Bank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class UserController {
    @PostMapping("/login")
    public ResponseEntity<UserAuthResponse> loginAuth(@RequestBody String loginDetails) {
        Gson gson = new Gson();
        UserAuth auth = gson.fromJson(loginDetails, UserAuth.class);
        UserAuthResponse response = new UserAuthResponse();

        if (loginDetails == null) {
            response.setMessage("Invalid login details.");
            response.setAuthorized(false);
            return ResponseEntity.ok(response);
        }
        User user = Bank.getInstance().getUser(auth.getUsername());
        if (user == null) {
            response.setMessage("User not found.");
            response.setAuthorized(false);
            return ResponseEntity.ok(response);
        }
        if (!user.getAuth().getPassword().equals(auth.getPassword())) {
            response.setMessage("Incorrect Password.");
            response.setAuthorized(false);
            return ResponseEntity.ok(response);
        }
        response.setMessage("Success!");
        response.setAuthorized(user.getAuth().getPassword().equals(auth.getPassword()));
        response.setResponseUUID(user.getUUID());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/user")
    public ResponseEntity<User> getUser(@RequestBody String uuid) {
        return ResponseEntity.ok(Bank.getInstance().getUser(UUID.fromString(uuid)));
    }

    @PostMapping("/openaccount")
    public ResponseEntity<Account> openAccount(@RequestBody String accountDetails) {
        Gson gson = new Gson();
        OpenAccountRequest request = gson.fromJson(accountDetails, OpenAccountRequest.class);
        AccountInfo info = AccountInfo.newAccountInfo(100.00);
        Account account = new Account(AccountType.valueOf(request.getAccountType().toUpperCase()), info);

        User user = Bank.getInstance().getUser(UUID.fromString(request.getUUID()));
        if (user == null) {
            return ResponseEntity.ok(null);
        }

        user.getWrapper().addAccount(account);
        System.out.println(user.getWrapper().getAccountList());
        return ResponseEntity.ok(account);
    }
}
