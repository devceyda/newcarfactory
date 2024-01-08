package com.carfactory.carfactory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carfactory.carfactory.entity.Brand;
import com.carfactory.carfactory.entity.Car;
import com.carfactory.carfactory.entity.CarRich;
import com.carfactory.carfactory.entity.Color;
import com.carfactory.carfactory.service.BrandService;
import com.carfactory.carfactory.service.CarService;
import com.carfactory.carfactory.service.ColorService;

//-----------------------------------------------------
// Title: FactoryController
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary:The FactoryController class is a Spring MVC controller handling various endpoints related to car operations, such as listing, filtering, deleting, and updating cars.
// It uses the @RequestMapping annotation to map HTTP requests to specific methods.
//The @ResponseBody annotation is used to indicate that the return value of the getCarsData method should be serialized directly to the body of the HTTP response.
//----------------------------------------------------
@Controller
public class FactoryController {

    private BrandService brandService;
    private ColorService colorService;
    private CarService carService;

    private List<CarRich> carList;

    public FactoryController(BrandService brandService, ColorService colorService, CarService carService) {
        this.brandService = brandService;
        this.colorService = colorService;
        this.carService = carService;
    }

    Car car = new CarRich(null, null, null, null, null, null, null, null, null, null, null, null);

    @GetMapping("/Cars")
    public String listCars() {

        return "Cars";
    }

    @RequestMapping(value = "/CarsData", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    @ResponseBody
    public List<CarRich> getCarsData() {

        carList = new ArrayList<>();
        carList = carService.searchCar(car);
        this.car = new CarRich();
        // listCars();
        return carList;
    }

    @RequestMapping(value = "/FilterCars", method = RequestMethod.POST)
    public String filterCars(@ModelAttribute("Car") Car car) {
        this.car = car;
        return "/Cars";
    }

    @RequestMapping(value = "/CarsDelete", method = RequestMethod.POST)
    public String deleteCarByID(@RequestParam("carID") Integer id) {
        carService.deleteCarByID(id);
        return "/Cars";
    }

    @RequestMapping(value = "/UpdateCar", method = RequestMethod.POST)
    public String updateCarByID(@ModelAttribute("Car") Car car, @RequestParam("id") Integer id) {
        Car existingCar = carService.getCarByID(id);
        existingCar.setCarID(id);
        existingCar.setColorID(car.getColorID());
        existingCar.setBrandID(car.getBrandID());
        existingCar.setModel(car.getModel());
        existingCar.setPrice(car.getPrice());
        existingCar.setGearType(car.getGearType());
        existingCar.setFuelType(car.getFuelType());
        existingCar.setIsRefurbished(car.getIsRefurbished());
        existingCar.setReleaseDate(car.getReleaseDate());

        // save updated student object
        carService.updateCar(existingCar);
        return "/Cars";
    }

    @ModelAttribute("colors")
    public List<Color> getColors() {
        return colorService.getAllColor();
    }

    @ModelAttribute("brands")
    public List<Brand> getBrands() {
        return brandService.getAllBrand();
    }


}
