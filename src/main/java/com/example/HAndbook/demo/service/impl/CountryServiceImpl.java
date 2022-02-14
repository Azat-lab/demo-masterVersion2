package com.example.HAndbook.demo.service.impl;


import com.example.HAndbook.demo.entity.Country;
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
    public Country saveByCountryAreaCodeId(Long id) {
        return countryRepository.save(saveByCountryAreaCodeId(id));
    }

    @Override
    public List<Country> findByCountryNameAndAddress(String countryName, String address) {
        return null;
    }

    @Override
    public Optional<Country> findByCountryAreaCodeId(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public long deleteByCountryAreaCodeId(Long id) {
        countryRepository.deleteById(deleteByCountryAreaCodeId(id));

        return 0;
    }
}
