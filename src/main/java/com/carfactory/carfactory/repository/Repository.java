package com.carfactory.carfactory.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Repository {

    private String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=CarFactory;encrypt=true;trustServerCertificate=true";

    private String username = "sa";

    private String password = "Deneme*.12";

    private Connection connection;

    public Connection getConnection() {

        try {
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return connection;

    }

    public void deneme() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/carfactory";
        String username = "root";
        String password = "Deneme*.12";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Connected to the database!");
                // Perform database operations here

                // Close the connection when done
                connection.close();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to the database failed.");
            e.printStackTrace();
        }
    }
}
