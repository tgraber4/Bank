package edu.missouri.csbank.bank.Users;

import java.util.Date;

public class RewardsEarned {
    // Earned Layout    --->    Date | Description | Amount | Type | Rewards Earned

    private Date date;
    private String description;
    private double amountSpent;
    private String type; // replace with enum (TODO)
    private double rewardsAmountEarned;

    public RewardsEarned(Date date, String description, double amountSpent, String type, double rewardsAmountEarned) {
        this.date = date;
        this.description = description;
        this.amountSpent = amountSpent;
        this.type = type;
        this.rewardsAmountEarned = rewardsAmountEarned;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(double amountSpent) {
        this.amountSpent = amountSpent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRewardsAmountEarned() {
        return rewardsAmountEarned;
    }

    public void setRewardsAmountEarned(double rewardsAmountEarned) {
        this.rewardsAmountEarned = rewardsAmountEarned;
    }
}
