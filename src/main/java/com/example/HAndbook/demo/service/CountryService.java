package com.example.HAndbook.demo.service;

import com.example.HAndbook.demo.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Country saveByCountryAreaCodeId(Long id);
    List<Country> findByCountryNameAndAddress(String countryName, String address);
    Optional<Country> findByCountryAreaCodeId(Long id);
    long deleteByCountryAreaCodeId(Long id);


}
