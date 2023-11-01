package com.carfactory.carfactory.service;

import java.util.HashMap;
import java.util.List;

import com.carfactory.carfactory.entity.Color;

public interface ColorService {
    
    List<Color> getAllColor();

    HashMap<String, Integer> getNumberOfColors();
}
