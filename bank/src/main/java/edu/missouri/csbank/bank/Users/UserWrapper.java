package edu.missouri.csbank.bank.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserWrapper {
    private final PersonalInfo info;
    private final List<Account> accountList;

    private final List<String> linkedBanks;

    private final Personalization personalization;

    private final Rewards userRewards;
    private final Date userAccountAge; // stored as a date


    private UserWrapper(PersonalInfo info, Personalization personalization, Rewards userRewards, Date userAccountAge, List<Account> accountList, List<String> linkedBanks) {
        this.info = info;
        this.personalization = personalization;
        this.userRewards = userRewards;
        this.userAccountAge = userAccountAge;
        this.accountList = accountList;
        this.linkedBanks = linkedBanks;
    }

    private UserWrapper(PersonalInfo info, Personalization personalization, Rewards userRewards) {
        this.info = info;
        this.personalization = personalization;
        this.userRewards = userRewards;
        this.userAccountAge = new Date();
        this.accountList = new ArrayList<>();
        this.linkedBanks = new ArrayList<>();
    }
    public static UserWrapper newUserWrapper(PersonalInfo info, Personalization personalization, Rewards userRewards) {
        return new UserWrapper(info, personalization, userRewards);
    }

    public static UserWrapper existingUserWrapper(PersonalInfo info, Personalization personalization, Rewards userRewards, Date userAccountAge, List<Account> accountList, List<String> linkedBanks) {
        return new UserWrapper(info, personalization, userRewards, userAccountAge, accountList, linkedBanks);
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

    public void addAccount (Account account) {
        this.accountList.add(account);
    }

    public void addLinkedBank (String linkedBank) {
        this.linkedBanks.add(linkedBank);
    }

    public boolean removeAccount (Account account) {
        return this.accountList.remove(account);
    }
    public boolean removeLinkedBank (String linkedBank) {
        return this.linkedBanks.remove(linkedBank);
    }
}