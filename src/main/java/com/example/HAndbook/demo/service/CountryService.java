package com.example.HAndbook.demo.service;

import com.example.HAndbook.demo.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    void saveCountryByCountryName(Country country);
    List<Country> findByCountryNameAndAddress(String countryName, String address);
    Country findByCountryAreaCodeId(Long id);
    void deleteByCountryAreaCodeId(Long id);


}
