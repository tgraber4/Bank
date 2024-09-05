package edu.missouri.csbank.bank.users;

import java.util.UUID;

public class UserAuthResponse {

    private String message;
    private boolean authorized;
    private UUID responseUUID;

    public UserAuthResponse() {

    }
    public UserAuthResponse(String message, boolean authorized, UUID responseUUID) {
        this.message = message;
        this.authorized = authorized;
        this.responseUUID = responseUUID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public UUID getResponseUUID() {
        return responseUUID;
    }

    public void setResponseUUID(UUID responseUUID) {
        this.responseUUID = responseUUID;
    }
}
