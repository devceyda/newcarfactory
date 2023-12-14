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
        //Deneme
        // // model.addAttribute("Cars", carService.getAllCar());
        // // CarRich car = new CarRich();
        // // model.addAttribute("Car", car);
        // // CarRich car = new CarRich();
        // //model.addAttribute("Cars", carService.searchCar(car));
        // //this.car = new CarRich();
        // // System.out.println(car.getPrice());
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

    // @GetMapping("/Cars/update/{id}")
    // public String updateCardForm(@PathVariable Integer id, Model model) {
    // model.addAttribute("Car", carService.getCarByID(id));
    // return "UpdateCar";
    // }

    // @PostMapping("/Cars/{id}")
    // public String updateCar(@PathVariable Integer id,
    // @ModelAttribute("Car") Car car,
    // Model model) {
    // // int CarID =Integer.parseInt(id);
    // // get student from database by id
    // Car existingCar = carService.getCarByID(id);
    // existingCar.setCarID(id);
    // existingCar.setColorID(car.getColorID());
    // existingCar.setBrandID(car.getBrandID());
    // existingCar.setModel(car.getModel());
    // existingCar.setPrice(car.getPrice());
    // existingCar.setGearType(car.getGearType());
    // existingCar.setFuelType(car.getFuelType());
    // existingCar.setIsRefurbished(car.getIsRefurbished());
    // existingCar.setReleaseDate(car.getReleaseDate());

    // // save updated student object
    // carService.updateCar(existingCar);
    // return "redirect:/Cars";
    // }

    // @GetMapping("/Cars/{id}")
    // public String deleteCar(@PathVariable Integer id) {
    // carService.deleteCarByID(id);
    // return "redirect:/Cars";
    // }

    // @PostMapping("/Cars")
    // public void SearchCar(
    // @RequestParam(name = "searchByBrand") Integer BrandID,
    // @RequestParam(name = "searchByModel") String Model,
    // @RequestParam(name = "searchByColor") Integer ColorID,
    // @RequestParam(name = "searchByPrice") Long Price,
    // @RequestParam(name = "searchByGearType") String GearType,
    // @RequestParam(name = "searchByFuelType") String FuelType,
    // @RequestParam(name = "searchByReleaseDate") Date ReleaseDate,
    // @RequestParam(name = "searchByIsRefurbished") Boolean IsRefurbished) {

    // if(BrandID != null){
    // System.out.println("succesful");
    // }

    // }

}
