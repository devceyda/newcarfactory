package com.carfactory.carfactory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//-----------------------------------------------------
// Title: MainPage controller
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary: Try to open the main web page.
//----------------------------------------------------
@Controller
public class MainPageController {

    @GetMapping("/CKCarFactory")
    public String mainPage() {
        return "MainPage";
    }

}
