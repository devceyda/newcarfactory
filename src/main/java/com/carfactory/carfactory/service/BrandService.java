package com.carfactory.carfactory.service;

import java.util.HashMap;
import java.util.List;

import com.carfactory.carfactory.entity.Brand;
import com.carfactory.carfactory.entity.BrandRich;
//-----------------------------------------------------
// Title: BrandService
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary: Both methods are declared in the interface, and the actual implementation is provided in the BrandServiceImpl class (which you shared earlier). The BrandServiceImpl class implements this BrandService interface and provides the logic for fetching brand-related information from the data source.
//----------------------------------------------------
public interface BrandService {

    List<Brand> getAllBrand();

    HashMap<String, Integer> getNumberOfBrands();
    HashMap<String, BrandRich> getPriceListOfBrand();


}


