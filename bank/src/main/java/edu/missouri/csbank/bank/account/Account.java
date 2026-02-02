package edu.missouri.csbank.bank.account;

import edu.missouri.csbank.bank.users.User;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    
    @Embedded
    private AccountInfo accountInfo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private User user;

    public Account() {}

    public Account(AccountType accountType, AccountInfo accountInfo) {
        this.accountType = accountType;
        this.accountInfo = accountInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public void updateBalance(double amount) {
        if (this.accountInfo != null) {
            this.accountInfo.setBalance(this.accountInfo.getBalance() + amount);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}