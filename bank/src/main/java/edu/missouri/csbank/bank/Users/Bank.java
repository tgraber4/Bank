package edu.missouri.csbank.bank.Users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Bank {
    private final Map<UUID, User> userMap = new HashMap<>();

    private static Bank instance = null;
    private Bank() {
    }
    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }
    public void addUser(User user) {
        userMap.put(UUID.randomUUID(), user);
    }
    public User getUser(UUID id) {
        return userMap.get(id);
    }
}
