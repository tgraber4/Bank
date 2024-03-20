package edu.missouri.csbank.bank.Users;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class User {
    private PersonalInfo info;

    private List<Account> accountList;

    private List<String> linkedBanks;

    private Personalization personalization;

    private Date UserAge;
    // date.getTime() -> converts in long form

    private final UUID uuid;

    // make a flowchart for layout
    public User() {
        this.uuid = UUID.randomUUID();
    }


}
