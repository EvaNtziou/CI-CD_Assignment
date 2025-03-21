package com.CICD.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SDB {
    private static final String DB_URL = "jdbc:sqlite:src/main/resources/SDB.db";  // SQLite DB file path

    static {
        try {
            Class.forName("org.sqlite.JDBC");  // Load the SQLite JDBC driver
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found.");
            e.printStackTrace();
        }
    }


    // Method to get a database connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Method to close database resources (not needed with try-with-resources but can be useful)
    public void close() {
        // Close connection if necessary, depending on how you manage it
    }
}
