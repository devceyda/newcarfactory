package com.carfactory.carfactory.service;

import java.util.HashMap;
import java.util.List;

import com.carfactory.carfactory.entity.Color;
//-----------------------------------------------------
// Title: ColorServices
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary:These methods are declared in the interface, and the actual implementation is expected to be provided in a class that implements the ColorService interface, such as the ColorServiceImpl class. The implementation class will provide the logic for fetching color-related information from the data source.
//----------------------------------------------------
public interface ColorService {
    
    List<Color> getAllColor();

    HashMap<String, Integer> getNumberOfColors();
}
