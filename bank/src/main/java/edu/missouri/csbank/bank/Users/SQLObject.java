package edu.missouri.csbank.bank.Users;



import java.util.Date;
import java.util.List;
import java.util.Objects;

public interface SQLObject {

    Tables getTable();
    void update();
    String valuesString();

    default String createTableString(List<String> typeList, List<String> typeNameList) {
        if (typeList.size() != typeNameList.size()) {
            System.out.println("(!) (!) size doesn't match up! (!) (!)");
            return "N/A";
        }
        String query = "";
        for (int i = 0; i < typeList.size(); i++) {
            query = query.concat("  " + typeNameList.get(i) + " ");
            if (Objects.equals(typeList.get(i).toLowerCase(), "string") || Objects.equals(typeList.get(i).toLowerCase(), "date")) {
                query = query.concat("VARCHAR(255)");
            } else if (Objects.equals(typeList.get(i).toLowerCase(), "int")) {
                query = query.concat("INT");
            }
            if ((i + 1) < typeList.size()) {
                query = query.concat(",\n");
            } else {
                query = query.concat("\n");
            }
        }
        return query;
    }

    String createString();

    public default long dateToInt(Date inputdate) {
        return inputdate.getTime();
    }
}
