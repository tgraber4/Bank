package edu.missouri.csbank.bank.Users;

import java.util.Calendar;
import java.util.Date;

public class PersonalInfo {
    private String firstName;
    private String middleName;
    private String lastName;

    private final Date dob;
    private String address;
    private String country;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    private int age; // don't include in constructor

    private int ssn;

    public PersonalInfo(String firstName, String middleName, String lastName, Date dob, String address, String country, String phoneNumber, String username, String password, int ssn) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.ssn = ssn;
    }

    private void updateAge() {
        long age = (System.currentTimeMillis() - dob.getTime()) / (60L * 60 * 24 * 365 * 1000);
        this.age = (int) age;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public int getAge() {
        updateAge();
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
