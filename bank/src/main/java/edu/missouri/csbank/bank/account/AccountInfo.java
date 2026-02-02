package edu.missouri.csbank.bank.account;

import jakarta.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class AccountInfo {

    private double balance;
    private int accountLimit;
    private double apr;
    private double cashbackRate;
    private int securityLevel;
    private String card;
    private Date accountAge;

    public AccountInfo() {
        this.accountAge = new Date();
    }

    public AccountInfo(double balance, int accountLimit, double apr, double cashbackRate, int securityLevel, String card) {
        this.balance = balance;
        this.accountLimit = accountLimit;
        this.apr = apr;
        this.cashbackRate = cashbackRate;
        this.securityLevel = securityLevel;
        this.card = card;
        this.accountAge = new Date();
    }

    public static AccountInfo newAccountInfo(double balance) {
        return new AccountInfo(balance, 0, 0, 0, 0, "");
    }

    public static AccountInfo newAccountInfo(double balance, int accountLimit, double APR, double cashbackRate, int securityLevel, String card) {
        return new AccountInfo(balance, accountLimit, APR, cashbackRate, securityLevel, card);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountLimit() {
        return accountLimit;
    }

    public void setAccountLimit(int accountLimit) {
        this.accountLimit = accountLimit;
    }

    public double getApr() {
        return apr;
    }

    public void setApr(double apr) {
        this.apr = apr;
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

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
    
    public Date getAccountAge() {
        return accountAge;
    }

    public void setAccountAge(Date accountAge) {
        this.accountAge = accountAge;
    }
}