package edu.missouri.csbank.bank.Users;

import edu.missouri.csbank.bank.sql.SQLConnectionManager;

public class Account {

    private final AccountType accountType;
    private String card;
    private final AccountInfo accountInfo;
    public Account(AccountType accountType, String card, AccountInfo accountInfo) {
        this.accountType = accountType;
        this.card = card;
        this.accountInfo = accountInfo;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }


}
