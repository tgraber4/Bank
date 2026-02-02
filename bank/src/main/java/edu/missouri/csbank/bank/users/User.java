package edu.missouri.csbank.bank.users;

import edu.missouri.csbank.bank.account.Account;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String username;
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_info_id", referencedColumnName = "id")
    private PersonalInfo personalInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Alert> alerts = new ArrayList<>();

    private Boolean transactionAlertsEnabled = true;
    private Boolean billAlertsEnabled = true;

    public User() {
        this.transactionAlertsEnabled = true;
        this.billAlertsEnabled = true;
    }

    public User(String username, String password, PersonalInfo personalInfo) {
        this.username = username;
        this.password = password;
        this.personalInfo = personalInfo;
        this.transactionAlertsEnabled = true;
        this.billAlertsEnabled = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isTransactionAlertsEnabled() {
        return transactionAlertsEnabled != null && transactionAlertsEnabled;
    }

    public void setTransactionAlertsEnabled(Boolean transactionAlertsEnabled) {
        this.transactionAlertsEnabled = transactionAlertsEnabled;
    }

    public Boolean isBillAlertsEnabled() {
        return billAlertsEnabled != null && billAlertsEnabled;
    }

    public void setBillAlertsEnabled(Boolean billAlertsEnabled) {
        this.billAlertsEnabled = billAlertsEnabled;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setUser(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.setUser(null);
    }
}
