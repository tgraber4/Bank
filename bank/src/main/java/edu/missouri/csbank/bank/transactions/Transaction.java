package edu.missouri.csbank.bank.transactions;

import java.util.Date;

public class Transaction {


    private Date date;
    private String counterparty; //- Represents the name of the other user in the transaction (generally a company)
    private String transactionDescription; //- Represents the category/type of transaction and contains details about the purchase/sale
    private double amount;
    private long companyID;

    public Transaction(Date date, String counterparty, String transactionDescription, double amount, long companyID) {
        this.date = date;
        this.counterparty = counterparty;
        this.transactionDescription = transactionDescription;
        this.amount = amount;
        this.companyID = companyID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(String counterparty) {
        this.counterparty = counterparty;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(long companyID) {
        this.companyID = companyID;
    }
}
