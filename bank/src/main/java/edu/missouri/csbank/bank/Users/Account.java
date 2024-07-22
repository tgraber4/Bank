package edu.missouri.csbank.bank.Users;

import edu.missouri.csbank.bank.sql.SQLConnectionManager;

public class Account implements SQLObject {

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

    @Override
    public void update(SQLConnectionManager connectionManager) {

    }

    @Override
    public void load() {

    }
}
