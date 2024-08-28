package edu.missouri.csbank.bank.rewards;

import java.util.Date;

public class RewardsSpent {
    // Spent Layout     --->    Date | Description | Amount | Category

    private Date date;
    private String description;
    private double amountSpent;
    private String Category; // maybe enum in future

    public RewardsSpent(Date date, String description, double amountSpent, String category) {
        this.date = date;
        this.description = description;
        this.amountSpent = amountSpent;
        Category = category;
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

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
