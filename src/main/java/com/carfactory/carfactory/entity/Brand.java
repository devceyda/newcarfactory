package com.carfactory.carfactory.entity;
// Title: Brand
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary: The Brand class has three private fields: BrandID (an integer representing the brand's ID), Brand (a string representing the brand's name), and BrandLogo (a string representing the URL or path to the brand's logo).
//----------------------------------------------------
public class Brand {

    private int BrandID;
    private String Brand;
    private String BrandLogo;

    public Brand(int brandID, String brand, String brandLogo) {
        BrandID = brandID;
        Brand = brand;
        BrandLogo = brandLogo;
    }

    public Brand() {
    }

    public int getBrandID() {
        return BrandID;
    }

    public String getBrandLogo() {
        return BrandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        BrandLogo = brandLogo;
    }

    public void setBrandID(int brandID) {
        BrandID = brandID;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

}
