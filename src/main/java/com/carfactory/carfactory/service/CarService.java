package com.carfactory.carfactory.service;

import java.util.HashMap;
import java.util.List;

import com.carfactory.carfactory.entity.Car;
import com.carfactory.carfactory.entity.CarRich;
//-----------------------------------------------------
// Title: CarService
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary: These methods are declared in the interface, and the actual implementation is provided in the CarServiceImpl class (which you shared earlier). The CarServiceImpl class implements this CarService interface and provides the logic for managing car-related information in the data source.
//----------------------------------------------------

public interface CarService {

    List<CarRich> getAllCar();

    Car addCar(Car car);

    CarRich getCarByID(int id);

    Car updateCar(Car car);

    void deleteCarByID(int id);

    List<CarRich> searchCar(Car car);

    HashMap<String, Integer> getReports();

}
