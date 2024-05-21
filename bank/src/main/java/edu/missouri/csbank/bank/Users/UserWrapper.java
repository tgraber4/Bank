package edu.missouri.csbank.bank.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserWrapper {
    private final PersonalInfo info;
    private final List<Account> accountList = new ArrayList<>();

    private final List<String> linkedBanks = new ArrayList<>();

    private final Personalization personalization;

    private final Rewards userRewards;
    private final Date userAccountAge; // stored as a date


    private UserWrapper(PersonalInfo info, Personalization personalization, Rewards userRewards, Date userAccountAge) {
        this.info = info;
        this.personalization = personalization;
        this.userRewards = userRewards;
        this.userAccountAge = userAccountAge;
    }

    private UserWrapper(PersonalInfo info, Personalization personalization, Rewards userRewards) {
        this.info = info;
        this.personalization = personalization;
        this.userRewards = userRewards;
        this.userAccountAge = new Date();
    }
    public static UserWrapper newUserWrapper(PersonalInfo info, Personalization personalization, Rewards userRewards) {
        return new UserWrapper(info, personalization, userRewards);
    }

    public static UserWrapper existingUserWrapper(PersonalInfo info, Personalization personalization, Rewards userRewards, Date userAccountAge) {
        return new UserWrapper(info, personalization, userRewards, userAccountAge);
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

    public int getUserAccountAgeInYears() {
        long age = (System.currentTimeMillis() - userAccountAge.getTime()) / (60L * 60 * 24 * 365 * 1000);
        return (int) age;
    }

    public PersonalInfo getInfo() {
        return info;
    }
}