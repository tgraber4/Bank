package edu.missouri.csbank.bank.types;

import java.util.Date;

public class TypeHolder {
    private Date dateHolder;
    private String stringHolder;
    private int intHolder;
    private double doubleHolder;

    public TypeHolder(Date dateHolder) {
        this.dateHolder = dateHolder;
    }
    public TypeHolder(String stringHolder) {
        this.stringHolder = stringHolder;
    }
    public TypeHolder(int intHolder) {
        this.intHolder = intHolder;
    }
    public TypeHolder(double doubleHolder) {
        this.doubleHolder = doubleHolder;
    }

    public long getDateHolder() {
        return dateHolder.getTime();
    }

    public void setDateHolder(Date dateHolder) {
        this.dateHolder = dateHolder;
    }

    public String getStringHolder() {
        return stringHolder;
    }

    public void setStringHolder(String stringHolder) {
        this.stringHolder = stringHolder;
    }

    public int getIntHolder() {
        return intHolder;
    }

    public void setIntHolder(int intHolder) {
        this.intHolder = intHolder;
    }

    public double getDoubleHolder() {
        return doubleHolder;
    }

    public void setDoubleHolder(double doubleHolder) {
        this.doubleHolder = doubleHolder;
    }
}
