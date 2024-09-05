package edu.missouri.csbank.bank.bankholder;

import edu.missouri.csbank.bank.users.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Bank {
    private final Map<UUID, User> userMap = new HashMap<>();
    private final Map<String, UUID> usernameMap = new HashMap<>();

    /*
    ---- Future Goals ----
    - Add transactions
    - Add loans
    - Add Scheduled Payments
           (-) Scheduled paying off credit account
           (-) Automatic payments to something each month
    - Monitor credit accounts
    */

    private String name;

    private static Bank instance = null;
    private Bank() {

    }
    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addUser(User user) {
        userMap.put(user.getUUID(), user);
        usernameMap.put(user.getAuth().getUsername(), user.getUUID());
    }

    public User getUser(String username) {
        return this.getUser(usernameMap.get(username));
    }
    public User getUser(UUID id) {
        if (id == null) return null;
        return userMap.get(id);
    }

}
