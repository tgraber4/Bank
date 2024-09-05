package edu.missouri.csbank.bank.account;

import java.util.UUID;

public class OpenAccountRequest {

    private String uuid;
    private String accountType;

    public OpenAccountRequest() {
    }

    public OpenAccountRequest(String uuid, String accountType) {
        this.uuid = uuid;
        this.accountType = accountType;
    }

    public String getUUID() {
        return uuid;
    }

    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
