package com.carfactory.carfactory.controller;

// Title: Reports controller
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary: The ReportsController class is a Spring MVC controller handling various endpoints related to generating reports on cars, colors, and brands.
//It uses the @RequestMapping annotation to map HTTP requests to specific methods.
//The @ResponseBody annotation is used to indicate that the return values of the methods should be serialized directly to the body of the HTTP response in JSON format.
//----------------------------------------------------
import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carfactory.carfactory.entity.BrandRich;
import com.carfactory.carfactory.service.BrandService;
import com.carfactory.carfactory.service.CarService;
import com.carfactory.carfactory.service.ColorService;

@Controller
public class ReportsController {

  private BrandService brandService;
  private ColorService colorService;
  private CarService carService;

  public ReportsController(BrandService brandService, ColorService colorService, CarService carService) {
    this.brandService = brandService;
    this.colorService = colorService;
    this.carService = carService;
  }

  @GetMapping("/Report")
  public String getRaports() {
    return "Report";
  }

  @RequestMapping(value = "/CarRaport", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
  @ResponseBody
  public HashMap<String, Integer> getCarData() {

    return carService.getReports();
  }

  @RequestMapping(value = "/ColorReport", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
  @ResponseBody
  public HashMap<String, Integer> getColorData() {

    return colorService.getNumberOfColors();
  }

  @RequestMapping(value = "/BrandReport", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
  @ResponseBody
  public HashMap<String, Integer> getBrandData() {

    return brandService.getNumberOfBrands();
  }

   @RequestMapping(value = "/BrandPriceReport", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
  @ResponseBody
  public HashMap<String, BrandRich> getBrandPriceData() {

    return brandService.getPriceListOfBrand();
  }



}
