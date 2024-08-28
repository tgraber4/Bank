package edu.missouri.csbank.bank.users;

import edu.missouri.csbank.bank.sql.SQLCreateType;
import edu.missouri.csbank.bank.sql.SQLObject;
import edu.missouri.csbank.bank.sql.Tables;

import java.util.*;

public class PersonalInfo implements SQLObject {
    private String firstName;
    private String middleName;
    private String lastName;
    private final Date dob;
    private String address;
    private String country;
    private String phoneNumber; // TODO: make this into home, mobile, extra phone numbers
    private String email; // TODO: allow multiple email and a primary one
    private String language;
    private int ssn;

    public PersonalInfo() {
        this.dob = new Date();
    }
    public PersonalInfo(String firstName, String middleName, String lastName, Date dob, String address, String country, String phoneNumber, String email, String language, int ssn) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.language = language;
        this.ssn = ssn;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAgeInYears() {
        long age = (System.currentTimeMillis() - dob.getTime()) / (60L * 60 * 24 * 365 * 1000);
        return (int) age;
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

    @Override
    public List<String> getTypeNameList() {
        return new ArrayList<String>(Arrays.asList("firstName", "middleName", "lastName", "dob", "address", "country", "phoneNumber", "email", "language", "ssn"));
    }
    @Override
    public Tables getTable() {
        return Tables.PERSONAL_INFO;
    }

    @Override
    public List<String> updateString() {
        List<String> updateString = new ArrayList<String>();
        updateString.add("'" + firstName + "'");
        updateString.add("'" + middleName + "'");
        updateString.add("'" + lastName + "'");
        updateString.add("" + dateToInt(dob));
        updateString.add("'" + address + "'");
        updateString.add("'" + country + "'");
        updateString.add("'" + phoneNumber + "'");
        updateString.add("'" + email + "'");
        updateString.add("'" + language + "'");
        updateString.add("" + ssn);
        return updateString;
    }

    @Override
    public String createString () {
        ArrayList<SQLCreateType> createList = new ArrayList<SQLCreateType>();
        createList.add(new SQLCreateType("firstName", "String"));
        createList.add(new SQLCreateType("middleName", "String"));
        createList.add(new SQLCreateType("lastName", "String"));
        createList.add(new SQLCreateType("dob", "Date"));
        createList.add(new SQLCreateType("address", "String"));
        createList.add(new SQLCreateType("country", "String"));
        createList.add(new SQLCreateType("phoneNumber", "String"));
        createList.add(new SQLCreateType("email", "String"));
        createList.add(new SQLCreateType("language", "String"));
        createList.add(new SQLCreateType("ssn", "Int"));
        return createTableString(createList);
    }
    @Override
    public String valuesString() {
        String valueString = "";
        valueString += "'" + firstName + "',";
        valueString += "'" + middleName + "',";
        valueString += "'" + lastName + "',";
        valueString += dateToInt(dob) + ",";
        valueString += "'" + address + "',";
        valueString += "'" + country + "',";
        valueString += "'" + phoneNumber + "',";
        valueString += "'" + email + "',";
        valueString += "'" + language + "',";
        valueString += "" + ssn;
        return valueString;
    }
}
