package com.carfactory.carfactory.service;

import java.util.HashMap;
import java.util.List;

import com.carfactory.carfactory.entity.Car;
import com.carfactory.carfactory.entity.CarRich;


public interface CarService {

    List<CarRich> getAllCar();

    Car addCar(Car car);

    CarRich getCarByID(int id);

    Car updateCar(Car car);

    void deleteCarByID(int id);

    List<CarRich> searchCar(Car car);

    HashMap<String, Integer> getReports();

}
