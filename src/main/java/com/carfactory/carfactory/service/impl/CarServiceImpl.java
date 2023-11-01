package com.carfactory.carfactory.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carfactory.carfactory.entity.Car;
import com.carfactory.carfactory.entity.CarRich;
import com.carfactory.carfactory.repository.Repository;
import com.carfactory.carfactory.service.CarService;

@Service
public class CarServiceImpl implements CarService {

    private CarRich rCar;
    Repository repository = new Repository();
    private List<CarRich> allCars;
    private HashMap<String, Integer> reports;
    String query;

    @Override
    public List<CarRich> getAllCar() {
        allCars = new ArrayList<>();
        query = "uspGetCar";

        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            // cb.setInt(1, 1);
            ResultSet rs = cb.executeQuery();
            while (rs.next()) {
                rCar = new CarRich();
                // car = new Car(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
                // rs.getLong(5), rs.getString(6),
                // rs.getString(7), rs.getBoolean(8), rs.getDate(9));

                rCar.setCarID(rs.getInt("CarID"));
                rCar.setColorID(rs.getInt("ColorID"));
                rCar.setBrandID(rs.getInt("BrandID"));
                rCar.setModel(rs.getString("Model"));
                rCar.setPrice(rs.getLong("Price"));
                rCar.setGearType(rs.getString("GearType"));
                rCar.setFuelType(rs.getString("FuelType"));
                rCar.setIsRefurbished(rs.getBoolean("IsRefurbished"));
                rCar.setReleaseDate(rs.getDate("ReleaseDate"));
                rCar.setBrand(rs.getString("Brand"));
                rCar.setColor(rs.getString("Color"));

                allCars.add(rCar);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return allCars;
    }

    @Override
    public Car addCar(Car car) {

        query = "{call uspInsertCar(?,?,?,?,?,?,?,?)}";
        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            cb.setInt("ColorID", car.getColorID());
            cb.setInt("BrandID", car.getBrandID());
            cb.setString("Model", car.getModel());
            cb.setLong("Price", car.getPrice());
            cb.setString("GearType", car.getGearType());
            cb.setString("FuelType", car.getFuelType());
            cb.setBoolean("IsRefurbished", car.getIsRefurbished());
            java.sql.Date sqlDate = new java.sql.Date(car.getReleaseDate().getTime());
            cb.setDate("ReleaseDate", (sqlDate));
            Boolean rs = cb.execute();
            System.out.println("Successfully added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return car;
    }

    @Override
    public CarRich getCarByID(int id) {
        rCar = new CarRich();
        query = "{call uspGetCarByID(?)}";

        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            cb.setInt(("CarID"), id);
            ResultSet rs = cb.executeQuery();
            rs.next();
            rCar.setCarID(rs.getInt("CarID"));
            rCar.setColorID(rs.getInt("ColorID"));
            rCar.setBrandID(rs.getInt("BrandID"));
            rCar.setModel(rs.getString("Model"));
            rCar.setPrice(rs.getLong("Price"));
            rCar.setGearType(rs.getString("GearType"));
            rCar.setFuelType(rs.getString("FuelType"));
            rCar.setIsRefurbished(rs.getBoolean("IsRefurbished"));
            rCar.setReleaseDate(rs.getDate("ReleaseDate"));
            rCar.setBrand(rs.getString("Brand"));
            rCar.setColor(rs.getString("Color"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rCar;

    }

    @Override
    public Car updateCar(Car car) {
        query = "{call uspUpdateCar(?,?,?,?,?,?,?,?,?)}";
        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            cb.setInt("CarID", car.getCarID());
            cb.setInt("ColorID", car.getColorID());
            cb.setInt("BrandID", car.getBrandID());
            cb.setString("Model", car.getModel());
            cb.setLong("Price", car.getPrice());
            cb.setString("GearType", car.getGearType());
            cb.setString("FuelType", car.getFuelType());
            cb.setBoolean("IsRefurbished", car.getIsRefurbished());
            java.sql.Date sqlDate = new java.sql.Date(car.getReleaseDate().getTime());
            cb.setDate("ReleaseDate", (sqlDate));
            Boolean rs = cb.execute();

            System.out.println("Succesfully Updated");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return car;
    }

    @Override
    public void deleteCarByID(int id) {
        query = "{call uspDeleteCarByID(?)}";
        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            cb.setInt("CarID", id);
            Boolean rs = cb.execute();
            System.out.println("Succesfully Deleted");
        } catch (Exception e) {

        }
    }

    @Override
    public List<CarRich> searchCar(Car car) {
        allCars = new ArrayList<>();
        query = "{call uspSearchCar(?,?,?,?,?,?,?,?,?,?)}";
        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            cb.setString("CarID", null);
            cb.setString("BrandLogo", null);
            if (car.getColorID() == null) {
                cb.setString("ColorID", null);
            } else {
                cb.setInt("ColorID", car.getColorID());
            }
            if (car.getBrandID() == null) {
                cb.setString("BrandID", null);
            } else {
                cb.setInt("BrandID", car.getBrandID());
            }
            if (car.getModel() == "") {
                cb.setString("Model", null);
            } else {
                cb.setString("Model", car.getModel());
            }
            if (car.getPrice() == null) {
                cb.setString("Price", null);
            } else {
                cb.setLong("Price", car.getPrice());
            }
            if (car.getGearType() == "") {
                cb.setString("GearType", null);
            } else {
                cb.setString("GearType", car.getGearType());
            }
            if (car.getFuelType() == "") {
                cb.setString("FuelType", null);
            } else {
                cb.setString("FuelType", car.getFuelType());
            }
            if (car.getIsRefurbished() == null) {
                cb.setString("IsRefurbished", null);
            } else {
                cb.setBoolean("IsRefurbished", car.getIsRefurbished());
            }
            if (car.getReleaseDate() == null) {
                cb.setString("ReleaseDateStart", null);
            } else {
                java.sql.Date sqlDate = new java.sql.Date(car.getReleaseDate().getTime());
                cb.setDate("ReleaseDateStart", (sqlDate));
            }

            ResultSet rs = cb.executeQuery();

            while (rs.next()) {
                rCar = new CarRich();
                // car = new Car(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
                // rs.getLong(5), rs.getString(6),
                // rs.getString(7), rs.getBoolean(8), rs.getDate(9));

                rCar.setCarID(rs.getInt("CarID"));
                rCar.setColorID(rs.getInt("ColorID"));
                rCar.setBrandID(rs.getInt("BrandID"));
                rCar.setModel(rs.getString("Model"));
                rCar.setPrice(rs.getLong("Price"));
                rCar.setGearType(rs.getString("GearType"));
                rCar.setFuelType(rs.getString("FuelType"));
                rCar.setIsRefurbished(rs.getBoolean("IsRefurbished"));
                rCar.setReleaseDate(rs.getDate("ReleaseDate"));
                rCar.setBrand(rs.getString("Brand"));
                rCar.setColor(rs.getString("Color"));
                rCar.setBrandLogo(rs.getString("BrandLogo"));

                allCars.add(rCar);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return allCars;

    }

    @Override
    public HashMap<String, Integer> getReports() {
        reports = new HashMap<>();
        query = "uspGetReport";
        int numberOfCar = 0;
        // int numberOfOtomatic = 0;
        // int numberOfManuel = 0;
        // int numberOfFuel = 0;
        // int numberOfDiesel = 0;
        // int numberOfHybrid = 0;
        // int numberOfElectric = 0;

        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            ResultSet rs1 = cb.executeQuery();
            while (rs1.next()) {
                numberOfCar = rs1.getInt("NumberOfCar");
            }
            reports.put("NumberOfCars", numberOfCar);
            cb.getMoreResults();
            ResultSet rs2 = cb.getResultSet();
            while (rs2.next()) {
                reports.put(rs2.getString("GearType"), rs2.getInt("NumberOfGear"));
               // numberOfOtomatic = rs2.getInt("NumberOfOtomatic");
            }
            //raports.put("NumberOfOtomatic", numberOfOtomatic);
            cb.getMoreResults();
            ResultSet rs3 = cb.getResultSet();
            while (rs3.next()) {
               reports.put(rs3.getString("FuelType"), rs3.getInt("NumberOfFuel"));
            }
           
            // cb.getMoreResults();
            // ResultSet rs4 = cb.getResultSet();
            // while (rs4.next()) {

            //         reports.put(rs4.getString("Color"), rs4.getInt("NumberOfColor"));
                
            // }
           
            // cb.getMoreResults();
            // ResultSet rs5 = cb.getResultSet();
            // while (rs5.next()) {
            //         reports.put(rs5.getString("Brand"), rs5.getInt("NumberOfBrand"));
                
            // }
           

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return reports;
    }

}
