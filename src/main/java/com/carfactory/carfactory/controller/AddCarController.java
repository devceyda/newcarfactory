package com.carfactory.carfactory.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carfactory.carfactory.entity.Brand;
import com.carfactory.carfactory.entity.Car;
import com.carfactory.carfactory.entity.Color;
import com.carfactory.carfactory.service.BrandService;
import com.carfactory.carfactory.service.CarService;
import com.carfactory.carfactory.service.ColorService;

//-----------------------------------------------------
// Title: AddCarController
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary: It uses the @ModelAttribute annotation to provide lists of colors and brands to the view.
// These lists are obtained by invoking the getAllColor() and getAllBrand() methods from ColorService and BrandService respectively.
//The addrCar method takes a Car object as a model attribute, which is populated with form data from the view. It then invokes the addCar method from CarService to add the new car.
//-----------------------------------------------------

@Controller
public class AddCarController {

    private BrandService brandService;
    private ColorService colorService;
    private CarService carService;

    public AddCarController(BrandService brandService, ColorService colorService, CarService carService) {
        this.brandService = brandService;
        this.colorService = colorService;
        this.carService = carService;
    }

    @ModelAttribute("colors")
    public List<Color> getColors() {
        return colorService.getAllColor();
    }

    @ModelAttribute("brands")
    public List<Brand> getBrands() {
        return brandService.getAllBrand();
    }

    @RequestMapping(value = "/AddCar", method = RequestMethod.POST)
    public String addrCar(@ModelAttribute("Car") Car car) {
        carService.addCar(car);
        return "redirect:/Cars";
    }
}
