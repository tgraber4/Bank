package edu.missouri.csbank.bank.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountInfo {

    private int accountNumber; // TODO: finish this
    private int routingNumber; // TODO: finish this
    private double balance;
    private String card;
    private int accountLimit;
    private double APR; // 0.##
    private double cashbackRate; // 0.##
    private int securityLevel; // determines where, how often, and how big of amounts you can use the account for
    private final Date accountAge; // stored as a date
    private final List<String> linkedAccounts;

    private AccountInfo(double balance, int accountLimit, double APR, double cashbackRate, int securityLevel, String card, Date accountAge, List<String> linkedAccounts) {
        this.balance = balance;
        this.accountLimit = accountLimit;
        this.APR = APR;
        this.cashbackRate = cashbackRate;
        this.securityLevel = securityLevel;
        this.card = card;
        this.accountAge = accountAge;
        this.linkedAccounts = linkedAccounts;
    }
    private AccountInfo(double balance, int accountLimit, double APR, double cashbackRate, int securityLevel, String card) {
        this.balance = balance;
        this.accountLimit = accountLimit;
        this.APR = APR;
        this.cashbackRate = cashbackRate;
        this.securityLevel = securityLevel;
        this.card = card;
        this.accountAge = new Date();
        this.linkedAccounts = new ArrayList<>();
    }

    public static AccountInfo newAccountInfo(double balance, int accountLimit, double APR, double cashbackRate, int securityLevel, String card) {
        return new AccountInfo(balance, accountLimit, APR, cashbackRate, securityLevel, card);
    }
    public static AccountInfo existingAccountInfo(double balance, int accountLimit, double APR, double cashbackRate, int securityLevel, String card, Date accountAge, List<String> linkedAccounts) {
        return new AccountInfo(balance, accountLimit, APR, cashbackRate, securityLevel, card, accountAge, linkedAccounts);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountLimit() {
        return accountLimit;
    }

    public void setAccountLimit(int accountLimit) {
        this.accountLimit = accountLimit;
    }

    public double getAPR() {
        return APR;
    }

    public void setAPR(double APR) {
        this.APR = APR;
    }

    public double getCashbackRate() {
        return cashbackRate;
    }

    public void setCashbackRate(double cashbackRate) {
        this.cashbackRate = cashbackRate;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    public int getAccountAgeInYears() {
        long age = (System.currentTimeMillis() - accountAge.getTime()) / (60L * 60 * 24 * 365 * 1000);
        return (int) age;
    }

    public List<String> getLinkedAccounts() {
        return linkedAccounts;
    }

    public void addLinkedAccount (String linkedAccount) {
        this.linkedAccounts.add(linkedAccount);
    }
    public boolean removeLinkedAccount (String linkedAccount) {
        return this.linkedAccounts.remove(linkedAccount);
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
