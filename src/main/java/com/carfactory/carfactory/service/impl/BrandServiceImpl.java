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
import com.carfactory.carfactory.repository.Repository;
import com.carfactory.carfactory.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
    private List<Brand> allBrands;
    private Brand brand;
    private HashMap<String, Integer> numberOfBrands;
    Repository repository = new Repository();

    @Override
    public List<Brand> getAllBrand() {
        allBrands = new ArrayList<>();
        String query = "uspGetBrand";

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
        String query = "uspGetReport";
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
                // brand = new Brand();
                // brand.setBrand(rs9.getString("Brand"));
                // brand.setNumberOfBrand(rs9.getInt("NumberOfBrand"));
                // numberOfBrands.add(brand);
                numberOfBrands.put(rs5.getString("Brand"), rs5.getInt("NumberOfBrand"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return numberOfBrands;
    }

}