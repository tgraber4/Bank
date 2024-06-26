package edu.missouri.csbank.bank.Users;

import java.util.Date;
import java.util.List;

public class AccountInfo {
    private double balance;
    private int accountLimit;
    private double APR; // 0.##
    private double cashbackRate; // 0.##
    private int securityLevel;
    private Date accountAge;
    private List<String> linkedAccounts;

    public AccountInfo(double balance, int accountLimit, double APR, double cashbackRate, int securityLevel, Date accountAge, List<String> linkedAccounts) {
        this.balance = balance;
        this.accountLimit = accountLimit;
        this.APR = APR;
        this.cashbackRate = cashbackRate;
        this.securityLevel = securityLevel;
        this.accountAge = accountAge;
        this.linkedAccounts = linkedAccounts;
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

    public Date getAccountAge() {
        return accountAge;
    }

    public void setAccountAge(Date accountAge) {
        this.accountAge = accountAge;
    }

    public List<String> getLinkedAccounts() {
        return linkedAccounts;
    }

    public void setLinkedAccounts(List<String> linkedAccounts) {
        this.linkedAccounts = linkedAccounts;
    }
}
