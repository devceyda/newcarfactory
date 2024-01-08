package com.carfactory.carfactory.entity;

public class BrandRich extends Brand {
    private double totalPrice;
    private double maxPrice;
    private double minPrice;
    private double averagePrice;

    public BrandRich(String brand, double totalPrice, double maxPrice, double minPrice,
            double averagePrice) {
        super(brand);
        this.totalPrice = totalPrice;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.averagePrice = averagePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BrandRich() {
    }
}
