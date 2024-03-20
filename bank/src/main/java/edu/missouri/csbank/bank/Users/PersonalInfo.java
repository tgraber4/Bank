package edu.missouri.csbank.bank.Users;

import java.util.Date;

public class PersonalInfo {
    private String firstName;
    private String middleName;
    private String lastName;

    private final Date dob;
    private String address;
    private String country;
    private String phoneNumber;
    private String username;
    private String password;
    private int age;

    private int ssn;

    public PersonalInfo(String firstName, String middleName, String lastName, Date dob, int ssn) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDOB() {
        return dob;
    }

    public int getSSN() {
        return ssn;
    }

    public void setSSN(int ssn) {
        this.ssn = ssn;
    }
}
