package com.carfactory.carfactory.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//-----------------------------------------------------
// Title: Datbase connections
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary: The class establishes a connection to a MySQL database using JDBC. The connection details include the URL (jdbc:mysql://localhost:3306/carfactory), username, and password.
//It loads the MySQL JDBC driver using Class.forName("com.mysql.cj.jdbc.Driver").
//The getConnection method attempts to establish a database connection, and if successful, it prints a message to indicate a successful connection. You can perform additional database operations inside the if (connection != null) block.
//----------------------------------------------------
public class Repository {



    String jdbcUrl = "jdbc:mysql://localhost:3306/carfactory";
    String username = "root";
    String password = "Deneme*.12";

    private Connection connection;

    public Connection getConnection() {

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                
                System.out.println("Connected to the database!");
             
            }

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to the database failed.");
            e.printStackTrace();
        }
        return connection;

    }



}
