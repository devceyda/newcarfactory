package com.carfactory.carfactory.entity;

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
