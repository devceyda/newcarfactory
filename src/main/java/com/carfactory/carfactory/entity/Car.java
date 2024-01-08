package com.carfactory.carfactory.entity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
//-----------------------------------------------------
// Title: Car
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary:  different attributes of a car, such as CarID, ColorID, BrandID, Model, Price, GearType, FuelType, IsRefurbished, and ReleaseDate.
//Additionally, there are two methods, getFormattedPrice and getFormattedReleaseDate, that provide formatted representations of the Price and ReleaseDate fields, respectively.
//The getFormattedPrice method uses the DecimalFormat class to format the price with a grouping separator and appends the currency symbol
//The getFormattedReleaseDate method uses the SimpleDateFormat class to format the release date according to the specified pattern "dd.MM.yyyy".
//----------------------------------------------------
public class Car {

    private Integer CarID;
    private Integer ColorID;
    private Integer BrandID;
    private String Model;
    private Long Price;
    private String GearType;
    private String FuelType;
    private Boolean IsRefurbished;
    private Date ReleaseDate;

    public Car() {
    }

    public Car(Integer carID, Integer colorID, Integer brandID, String model, Long price, String gearType, String fuelType,
            Boolean isRefurbished, Date releaseDate) {
        CarID = carID;
        ColorID = colorID;
        BrandID = brandID;
        Model = model;
        Price = price;
        GearType = gearType;
        FuelType = fuelType;
        IsRefurbished = isRefurbished;
        ReleaseDate = releaseDate;
    }

    public Integer getCarID() {
        return CarID;
    }

    public void setCarID(Integer carID) {
        CarID = carID;
    }

    public Integer getColorID() {
        return ColorID;
    }

    public void setColorID(Integer colorID) {
        ColorID = colorID;
    }

    public Integer getBrandID() {
        return BrandID;
    }

    public void setBrandID(Integer brandID) {
        BrandID = brandID;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Long getPrice() {
        return Price;
    }

    public String getFormattedPrice() {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.ITALY);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator('.');
        formatter.setDecimalFormatSymbols(symbols);
        String p = formatter.format(getPrice());
        return p + "  TL";
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public String getGearType() {
        return GearType;
    }

    public void setGearType(String gearType) {
        GearType = gearType;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String fuelType) {
        FuelType = fuelType;
    }

    public Boolean getIsRefurbished() {
        return IsRefurbished;
    }

    public void setIsRefurbished(Boolean isRefurbished) {
        IsRefurbished = isRefurbished;
    }

    public Date getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getFormattedReleaseDate() {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formattedReleaseDate = simpleDateFormat.format(getReleaseDate());
        return formattedReleaseDate;
    }

}
