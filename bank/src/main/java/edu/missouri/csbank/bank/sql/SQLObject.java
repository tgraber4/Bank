package edu.missouri.csbank.bank.sql;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public interface SQLObject {

    Tables getTable();
    List<String> updateString();
    String valuesString();

    List<String> getTypeNameList();

    default String createTableString(ArrayList<SQLCreateType> createList) {
        String query = "";
        for (SQLCreateType c : createList) {
            query = query.concat("  " + c.getTypeName() + " ");
            if (Objects.equals(c.getType().toLowerCase(), "string") || Objects.equals(c.getType().toLowerCase(), "date")) {
                query = query.concat("VARCHAR(255)");
            } else if (Objects.equals(c.getType().toLowerCase(), "int")) {
                query = query.concat("INT");
            }
            query = query.concat(",\n");
        }
        query = query.substring(0, query.length()-2) + query.substring(query.length()-1, query.length()); // removes comma
        return query;
    }

    String createString();

    public default long dateToInt(Date inputdate) {
        return inputdate.getTime();
    }
}
