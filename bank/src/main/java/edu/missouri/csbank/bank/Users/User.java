package edu.missouri.csbank.bank.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class User {
    private final PersonalInfo info;

    private final List<Account> accountList = new ArrayList<>();

    private final List<String> linkedBanks = new ArrayList<>();

    private final Personalization personalization;

    private final Rewards userRewards;
    private final Date userAccountAge;
    // date.getTime() -> converts in long form

    private final UUID uuid;

    // make a flowchart for layout



    // make an old user
    private User(PersonalInfo info, Personalization personalization, Rewards userRewards, Date userAccountAge, UUID uuid) {
        this.info = info;
        this.personalization = personalization;
        this.userRewards = userRewards;
        this.userAccountAge = userAccountAge;
        this.uuid = uuid;
    }

    // makes a new user
    private User(PersonalInfo info, Personalization personalization, Rewards userRewards) {
        this.info = info;
        this.personalization = personalization;
        this.userRewards = userRewards;
        this.userAccountAge = new Date();
        this.uuid = UUID.randomUUID();
    }

    public static User newUser(PersonalInfo info, Personalization personalization, Rewards userRewards) {
        return new User(info, personalization, userRewards);
    }
    public static User existingUser(PersonalInfo info, Personalization personalization, Rewards userRewards, Date userAccountAge, UUID uuid) {
        return new User(info, personalization, userRewards, userAccountAge, uuid);
    }


    public PersonalInfo getInfo() {
        return info;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public List<String> getLinkedBanks() {
        return linkedBanks;
    }

    public Personalization getPersonalization() {
        return personalization;
    }

    public Rewards getUserRewards() {
        return userRewards;
    }

    public Date getUserAccountAge() {
        return userAccountAge;
    }

    public UUID getUUID() {
        return uuid;
    }
}
