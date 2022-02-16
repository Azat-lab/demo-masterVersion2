package com.example.HAndbook.demo.controllers;


import com.example.HAndbook.demo.entity.Country;
import com.example.HAndbook.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryRestController {
    private final CountryService countryService;
@Autowired
    public CountryRestController(CountryService countryService) {

    this.countryService = countryService;
    }

    @GetMapping(value ="/find/{id}")
    public ResponseEntity<Country> getCountryByCountryAreaCodeId(@PathVariable("id") Long CountryAreaCodeId){
        Optional<Country> countryData = Optional.ofNullable(countryService.findByCountryAreaCodeId(CountryAreaCodeId));
        return countryData.map(country -> new ResponseEntity<>(country, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
//
    @GetMapping("/countryName")
    public ResponseEntity<List<Country>> findByCountryNameOrAddress(){
        try{
            List<Country> country = countryService.findByCountryNameAndAddress("cron", "Troll and 55");
            if(country.isEmpty()){
                return new ResponseEntity<>(HttpStatus.CONTINUE);
            }
            return  new ResponseEntity<>(country, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id") Long CountryAreaCodeId ){
        try{
            countryService.deleteByCountryAreaCodeId(CountryAreaCodeId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/save")
    public ResponseEntity<Country> createOperator(@RequestBody @Validated Country country) {
        countryService.saveCountryByCountryName(country);
        return new ResponseEntity<>(HttpStatus.CREATED);
}}
