package edu.missouri.csbank.bank.sql;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DBPasswordManager {

    private String password;
    public DBPasswordManager() {
        password = readPassword(new File("files/db-password"));
    }

    public String getPassword() {
        return password;
    }

    private String readPassword(File passwordFile) {
        try {
            Scanner scanner = new Scanner(passwordFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                if (!line.startsWith("sql-pass=")) continue;
                return line.split("sql-pass=")[1];
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Passwords file not found! It may not exist.");
        }
        return null;
    }
}