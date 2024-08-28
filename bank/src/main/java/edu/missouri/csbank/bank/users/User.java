package edu.missouri.csbank.bank.users;

import edu.missouri.csbank.bank.account.Account;

import java.util.UUID;

public class User {

    private String username, password;
    private final UserWrapper wrapper;

    private final UUID uuid;

    // make a flowchart for layout




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

    public void addAccount (Account account) {
        this.wrapper.addAccount(account);
    }
    public void addLinkedBank (String linkedBank) {
        this.wrapper.addLinkedBank(linkedBank);
    }

    public boolean removeAccount (Account account) {
        return this.wrapper.removeAccount(account);
    }
    public boolean removeLinkedBank (String linkedBank) {
        return this.wrapper.removeLinkedBank(linkedBank);
    }
}