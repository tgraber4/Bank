package edu.missouri.csbank.bank.Users;

import java.util.ArrayList;
import java.util.List;

public class Rewards {
    private double rewardsBalance;
    private final List<RewardsEarned> rewardsEarnedHistory;
    private final List<RewardsSpent> rewardsSpentHistory;
    private List<String> rewardsPerks; // might need to switch to rewards level where different levels give different perks

    private List<String> rewardsDeals; // convert into class later Ex: https://www.doctorofcredit.com/wp-content/uploads/2023/06/Screenshot-2023-06-05-at-3.59.33-PM-1024x372.png
    // title, amount, description
    private Rewards(double rewardsBalance, List<RewardsEarned> rewardsEarnedHistory, List<RewardsSpent> rewardsSpentHistory, List<String> rewardsDeals) {
        this.rewardsBalance = rewardsBalance;
        this.rewardsEarnedHistory = rewardsEarnedHistory;
        this.rewardsSpentHistory = rewardsSpentHistory;
        this.rewardsDeals = rewardsDeals;
    }

    private Rewards(double rewardsBalance, List<String> rewardsDeals) {
        this.rewardsBalance = rewardsBalance;
        this.rewardsEarnedHistory = new ArrayList<>();
        this.rewardsSpentHistory = new ArrayList<>();
        this.rewardsDeals = rewardsDeals;
    }

    public static Rewards newRewards(double rewardsBalance, List<String> rewardsDeals) {
        return new Rewards(rewardsBalance, rewardsDeals);
    }

    public static Rewards existingRewards(double rewardsBalance, List<RewardsEarned> rewardsEarnedHistory, List<RewardsSpent> rewardsSpentHistory, List<String> rewardsDeals) {
        return new Rewards(rewardsBalance, rewardsEarnedHistory, rewardsSpentHistory, rewardsDeals);
    }

    public double getRewardsBalance() {
        return rewardsBalance;
    }

    public void setRewardsBalance(int rewardsBalance) {
        this.rewardsBalance = rewardsBalance;
    }

    public List<String> getRewardsDeals() {
        return rewardsDeals;
    }

    public void setRewardsDeals(List<String> rewardsDeals) {
        this.rewardsDeals = rewardsDeals;
    }

    public List<RewardsEarned> getRewardsEarnedHistory() {
        return rewardsEarnedHistory;
    }

    public List<RewardsSpent> getRewardsSpentHistory() {
        return rewardsSpentHistory;
    }

    public void addRewardsEarned (RewardsEarned rewardsEarned) {
        this.rewardsEarnedHistory.add(rewardsEarned);
    }

    public boolean removeRewardsEarned (RewardsEarned rewardsEarned) {
        return this.rewardsEarnedHistory.remove(rewardsEarned);
    }
}
