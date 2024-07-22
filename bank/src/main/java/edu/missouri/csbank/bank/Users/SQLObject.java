package edu.missouri.csbank.bank.Users;

import edu.missouri.csbank.bank.sql.SQLConnectionManager;

public interface SQLObject {

    void update(SQLConnectionManager connectionManager);
    void load();
    //etc.
}
