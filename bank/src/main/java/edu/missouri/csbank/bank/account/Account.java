package edu.missouri.csbank.bank.account;


public class Account {

    private final AccountType accountType;
    private final AccountInfo accountInfo;
    public Account(AccountType accountType, AccountInfo accountInfo) {
        this.accountType = accountType;
        this.accountInfo = accountInfo;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }


}
