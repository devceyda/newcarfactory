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

}
