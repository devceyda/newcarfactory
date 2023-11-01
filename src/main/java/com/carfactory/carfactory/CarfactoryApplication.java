package com.carfactory.carfactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication

public class CarfactoryApplication {

	// static String dbUrl =
	// "jdbc:sqlserver://localhost:1433;databaseName=CarFactory;encrypt=true;trustServerCertificate=true";
	// static String username= "sa";
	// static String password = "Deneme*.12";

	public static void main(String[] args) {
		SpringApplication.run(CarfactoryApplication.class, args);

		/*
		 * Connection conn = null;
		 * 
		 * try {
		 * conn =DriverManager.getConnection(dbUrl, username, password);
		 * System.out.println("Successful");
		 * 
		 * String query = "uspGetBrand";
		 * CallableStatement cb = conn.prepareCall(query);
		 * 
		 * ResultSet rs = cb.executeQuery();
		 * 
		 * while (rs.next()){
		 * System.out.println(rs.getString(2));
		 * }
		 * 
		 * 
		 * } catch (Exception e) {
		 * System.out.println("Unsuccessful");
		 * System.out.println(e.getMessage());
		 * }
		 */

	}

}
