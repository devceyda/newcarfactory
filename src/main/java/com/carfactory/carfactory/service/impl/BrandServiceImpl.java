package com.carfactory.carfactory.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carfactory.carfactory.entity.Brand;
import com.carfactory.carfactory.entity.BrandRich;
import com.carfactory.carfactory.repository.Repository;
import com.carfactory.carfactory.service.BrandService;

//-----------------------------------------------------
// Title: BrandServiceImp
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary:  The class is annotated with @Service, indicating that it is a Spring service component.
// It implements the BrandService interface, providing implementations for the getAllBrand and getNumberOfBrands methods.
//The getAllBrand method retrieves all brands by calling a stored procedure named uspGetBrand. It creates Brand objects for each result row and adds them to the allBrands list.
//The getNumberOfBrands method retrieves a report on the number of brands using a stored procedure named uspGetReport. It populates a HashMap<String, Integer> named numberOfBrands where the brand names are keys, and the corresponding number of brands are values.
//The database connection is obtained using the repository.getConnection() method from the Repository class.
//The code uses CallableStatement to execute stored procedures and ResultSet to retrieve the results.
//----------------------------------------------------
@Service
public class BrandServiceImpl implements BrandService {
    private List<Brand> allBrands;
    private Brand brand;
    private HashMap<String, Integer> numberOfBrands;
    private HashMap<String, BrandRich> brandPrices;
    Repository repository = new Repository();

    @Override
    public List<Brand> getAllBrand() {
        allBrands = new ArrayList<>();
        String query = "{CALL uspGetBrand}";

        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            ResultSet rs = cb.executeQuery();
            while (rs.next()) {
                brand = new Brand();
                brand.setBrandID(rs.getInt("BrandID"));
                brand.setBrand(rs.getString("Brand"));
                brand.setBrandLogo(rs.getString("BrandLogo"));
                allBrands.add(brand);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return allBrands;
    }

    @Override
    public HashMap<String, Integer> getNumberOfBrands() {
        numberOfBrands = new HashMap<>();
        String query = "{CALL uspGetReport}";
        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            ResultSet rs1 = cb.executeQuery();

            cb.getMoreResults();
            ResultSet rs2 = cb.getResultSet();

            cb.getMoreResults();
            ResultSet rs3 = cb.getResultSet();

            cb.getMoreResults();
            ResultSet rs4 = cb.getResultSet();

            cb.getMoreResults();
            ResultSet rs5 = cb.getResultSet();
            while (rs5.next()) {
                numberOfBrands.put(rs5.getString("Brand"), rs5.getInt("NumberOfBrand"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return numberOfBrands;
    }

    @Override
    public HashMap<String, BrandRich> getPriceListOfBrand() {
        brandPrices = new HashMap<>();
        String query = "{CALL uspGetPriceListOfBrand}";
        BrandRich brandR;

        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            ResultSet rs = cb.executeQuery();

            while (rs.next()) {
                brandR = new BrandRich(rs.getString("Brand"), rs.getDouble("totalPrice"), rs.getDouble("maxPrice"),
                        rs.getDouble("minPrice"), rs.getDouble("averagePrice"));
                    
                brandPrices.put(brandR.getBrand(), brandR);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return brandPrices;
    }

}