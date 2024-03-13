package edu.missouri.csbank.bank.Users;

import java.util.UUID;

public class User {
    private PersonalInfo info;

    private final UUID uuid;


    //TODO: Remove later
    public User(UUID uuid) {
        this.uuid = uuid;
    }
}
