package edu.missouri.csbank.bank.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class User {

    private String username, password;
    private final UserWrapper wrapper;

    private final UUID uuid;

    // make a flowchart for layout



    // make an old user
    private User(UUID uuid, UserWrapper wrapper) {
        this.uuid = uuid;
        this.wrapper = wrapper;
    }

    // makes a new user
    private User(UserWrapper wrapper) {
        this.uuid = UUID.randomUUID();
        this.wrapper = wrapper;
    }

    public static User newUser(UserWrapper wrapper) {
        return new User(wrapper);
    }
    public static User existingUser(UUID uuid, UserWrapper wrapper) {
        return new User(uuid, wrapper);
    }

    public UserWrapper getWrapper() {
        return wrapper;
    }

    public UUID getUUID() {
        return uuid;
    }
}