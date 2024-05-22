package edu.missouri.csbank.bank.Users;

import java.util.Date;
import java.util.List;

public class AccountInfo {

    private int accountNumber; // TODO: finish this
    private int routingNumber; // TODO: finish this
    private double balance;
    private int accountLimit;
    private double APR; // 0.##
    private double cashbackRate; // 0.##
    private int securityLevel;
    private final Date accountAge; // stored as a date
    private List<String> linkedAccounts;

    private AccountInfo(double balance, int accountLimit, double APR, double cashbackRate, int securityLevel, Date accountAge) {
        this.balance = balance;
        this.accountLimit = accountLimit;
        this.APR = APR;
        this.cashbackRate = cashbackRate;
        this.securityLevel = securityLevel;
        this.accountAge = accountAge;
    }
    private AccountInfo(double balance, int accountLimit, double APR, double cashbackRate, int securityLevel) {
        this.balance = balance;
        this.accountLimit = accountLimit;
        this.APR = APR;
        this.cashbackRate = cashbackRate;
        this.securityLevel = securityLevel;
        this.accountAge = new Date();
    }

    public static AccountInfo newAccountInfo(double balance, int accountLimit, double APR, double cashbackRate, int securityLevel) {
        return new AccountInfo(balance, accountLimit, APR, cashbackRate, securityLevel);
    }
    public static AccountInfo existingAccountInfo(double balance, int accountLimit, double APR, double cashbackRate, int securityLevel, Date accountAge) {
        return new AccountInfo(balance, accountLimit, APR, cashbackRate, securityLevel, accountAge);
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

    public void setLinkedAccounts(List<String> linkedAccounts) {
        this.linkedAccounts = linkedAccounts;
    }

    public void addLinkedAccount (String linkedAccount) {
        this.linkedAccounts.add(linkedAccount);
    }
    public boolean removeLinkedAccount (String linkedAccount) {
        return this.linkedAccounts.remove(linkedAccount);
    }
}
