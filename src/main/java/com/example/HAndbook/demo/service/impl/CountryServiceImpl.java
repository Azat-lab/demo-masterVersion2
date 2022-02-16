package com.example.HAndbook.demo.service.impl;


import com.example.HAndbook.demo.entity.Country;
import com.example.HAndbook.demo.entity.Operator;
import com.example.HAndbook.demo.exception.CountryNotFoundException;
import com.example.HAndbook.demo.exception.OperatorNotFoundException;
import com.example.HAndbook.demo.repository.CountryRepository;
import com.example.HAndbook.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;

    @Override
    public void saveCountryByCountryName(Country country) {
        countryRepository.save(country);
    }

    @Override
    public List<Country> findByCountryNameAndAddress(String countryName, String address) {
        return findByCountryNameAndAddress(countryName, address);
    }
    @Override
    public Country findByCountryAreaCodeId(Long id) {
        Optional<Country> optional = countryRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new CountryNotFoundException("Country with Id: " + id);
        }
    }

    @Override
    public void deleteByCountryAreaCodeId(Long id) {
        countryRepository.deleteById(id);
    }
}
