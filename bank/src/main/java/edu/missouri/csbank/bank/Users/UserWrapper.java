package edu.missouri.csbank.bank.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserWrapper {

    public UserWrapper(PersonalInfo info, Personalization personalization, Rewards userRewards, Date userAccountAge) {
        this.info = info;
        this.personalization = personalization;
        this.userRewards = userRewards;
        this.userAccountAge = userAccountAge;
    }

    private final PersonalInfo info;
    private final List<Account> accountList = new ArrayList<>();

    private final List<String> linkedBanks = new ArrayList<>();

    private final Personalization personalization;

    private final Rewards userRewards;
    private final Date userAccountAge;
    // date.getTime() -> converts in long form


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

    public PersonalInfo getInfo() {
        return info;
    }
}
