package edu.missouri.csbank.bank.sql;

public class SQLCreateType {
    private String typeName;
    private String type;

    public SQLCreateType(String typeName, String type) {
        this.typeName = typeName;
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getType() {
        return type;
    }
}
