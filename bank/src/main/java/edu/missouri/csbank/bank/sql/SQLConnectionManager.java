package edu.missouri.csbank.bank.sql;

import java.sql.*;

public class SQLConnectionManager {

    //TODO: Consider making this configurable
    private final String user = "postgres";
    private final String connURL = "jdbc:postgresql://localhost:5432/bank";

    private final Connection connection;

    /*
    user: name
    password: whatever
     */

    /*
    Get connected to DB
     */
    public SQLConnectionManager(String password) {
        connection = initConnection(password);
    }

    private Connection initConnection(String password) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connURL, user, password);

        } catch (SQLException exception) {
            exception.printStackTrace();

            System.out.println("Error when attempting to connect to the database.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }
}