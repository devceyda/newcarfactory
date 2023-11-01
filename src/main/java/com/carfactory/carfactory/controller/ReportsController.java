package com.carfactory.carfactory.controller;

import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
