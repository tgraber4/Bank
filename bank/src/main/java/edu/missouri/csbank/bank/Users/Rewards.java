package edu.missouri.csbank.bank.Users;

import java.util.List;

public class Rewards {
    private int rewardsBalance;
    private double rewardsRate;

    private String rewardsHistory; // convert into list of classes later
    // Class will have amount spent and spending reason

    private List<String> rewardsDeals; // convert into class later Ex: https://www.doctorofcredit.com/wp-content/uploads/2023/06/Screenshot-2023-06-05-at-3.59.33-PM-1024x372.png
    // title, amount, description
    public Rewards(int rewardsBalance, double rewardsRate, String rewardsInfo, List<String> rewardsDeals) {
        this.rewardsBalance = rewardsBalance;
        this.rewardsRate = rewardsRate;
        this.rewardsHistory = rewardsInfo;
        this.rewardsDeals = rewardsDeals;
    }

    public int getRewardsBalance() {
        return rewardsBalance;
    }

    public void setRewardsBalance(int rewardsBalance) {
        this.rewardsBalance = rewardsBalance;
    }

    public double getRewardsRate() {
        return rewardsRate;
    }

    public void setRewardsRate(double rewardsRate) {
        this.rewardsRate = rewardsRate;
    }

    public String getRewardsHistory() {
        return rewardsHistory;
    }

    public void setRewardsHistory(String rewardsHistory) {
        this.rewardsHistory = rewardsHistory;
    }

    public List<String> getRewardsDeals() {
        return rewardsDeals;
    }

    public void setRewardsDeals(List<String> rewardsDeals) {
        this.rewardsDeals = rewardsDeals;
    }
}
