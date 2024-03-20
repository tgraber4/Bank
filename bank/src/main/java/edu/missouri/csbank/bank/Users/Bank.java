package edu.missouri.csbank.bank.Users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Bank {
    private final Map<UUID, User> userMap = new HashMap<>();

    private List<String> Transactions;
}
