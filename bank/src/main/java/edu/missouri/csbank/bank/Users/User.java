package edu.missouri.csbank.bank.Users;

import java.util.Date;
import java.util.UUID;

public class User {
    private PersonalInfo info;

    private Date UserAge;
    // date.getTime() -> converts in long form

    private final UUID uuid;

    // make a flowchart for layout
    public User() {
        this.uuid = UUID.randomUUID();
    }


}
