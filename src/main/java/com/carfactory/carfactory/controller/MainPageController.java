package com.carfactory.carfactory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/CKCarFactory")
    public String mainPage() {

        return "MainPage";
    }

}
