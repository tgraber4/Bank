package edu.missouri.csbank.bank.account;

import java.util.UUID;

public class OpenAccountRequest {

    private String uuid;
    private String accountType;
    private String nickname;

    public OpenAccountRequest() {
    }

    public OpenAccountRequest(String uuid, String accountType, String nickname) {
        this.uuid = uuid;
        this.accountType = accountType;
        this.nickname = nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
