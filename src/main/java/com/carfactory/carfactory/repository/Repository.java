package com.carfactory.carfactory.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

    // private String dbURL =
    // "jdbc:sqlserver://localhost:1433;databaseName=CarFactory;encrypt=true;trustServerCertificate=true";

    // private String username = "sa";

    // private String password = "Deneme*.12";

    String jdbcUrl = "jdbc:mysql://localhost:3306/carfactory";
    String username = "root";
    String password = "Deneme*.12";

    private Connection connection;

    public Connection getConnection() {

        // try {
        // connection = DriverManager.getConnection(jdbcUrl, username, password);
        // } catch (SQLException e) {

        // e.printStackTrace();
        // }

        // return connection;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                //String query = "select * from car";
                System.out.println("Connected to the database!");
                // CallableStatement cb = connection.prepareCall(query);
                // ResultSet rs = cb.executeQuery();
                // while(rs.next()){

                //     System.out.println(rs.getString(4));
                // }
                // Perform database operations here

                // Close the connection when done
               // connection.close();
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

    // public void deneme() {
    // String jdbcUrl = "jdbc:mysql://localhost:3306/carfactory";
    // String username = "root";
    // String password = "Deneme*.12";

    // try {
    // // Load the JDBC driver
    // Class.forName("com.mysql.cj.jdbc.Driver");

    // // Establish a connection
    // Connection connection = DriverManager.getConnection(jdbcUrl, username,
    // password);

    // if (connection != null) {
    // System.out.println("Connected to the database!");
    // // Perform database operations here

    // // Close the connection when done
    // connection.close();
    // }

    // } catch (ClassNotFoundException e) {
    // System.out.println("MySQL JDBC Driver not found.");
    // e.printStackTrace();
    // } catch (SQLException e) {
    // System.out.println("Connection to the database failed.");
    // e.printStackTrace();
    // }

}
