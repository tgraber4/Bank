package edu.missouri.csbank.bank.Users;

import edu.missouri.csbank.bank.sql.SQLConnectionManager;
import edu.missouri.csbank.bank.types.TypeHolder;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class PersonalInfo implements SQLObject{
    //TODO: Add unique id so that this can be updated in SQL table
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
    public List<String> getTypeList () {
        return new ArrayList<String>(Arrays.asList("String", "String", "String", "Date", "String", "String", "String", "String", "String", "Int"));
    }
    public List<String> getTypeNameList () {
        return new ArrayList<String>(Arrays.asList("firstName", "middleName", "lastName", "dob", "address", "country", "phoneNumber", "email", "language", "ssn"));
    }
    public List<TypeHolder> getTypeHolderList () {
        List<TypeHolder> tempList = new ArrayList<TypeHolder>();
        tempList.add(new TypeHolder(this.firstName));
        tempList.add(new TypeHolder(this.middleName));
        tempList.add(new TypeHolder(this.lastName));
        tempList.add(new TypeHolder(this.dob));
        tempList.add(new TypeHolder(this.address));
        tempList.add(new TypeHolder(this.country));
        tempList.add(new TypeHolder(this.phoneNumber));
        tempList.add(new TypeHolder(this.email));
        tempList.add(new TypeHolder(this.language));
        tempList.add(new TypeHolder(this.ssn));
        return tempList;
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
    public void update(SQLConnectionManager connectionManager) {
        String query = "UPDATE " + "PersonalInfo" + "\n";
        query = query.concat("SET " + this.getTypeNameList().get(0) + " = " + "'" + this.getFirstName() + "';");
        System.out.println(query);
        try {
            PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
            int result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {

    }
}
