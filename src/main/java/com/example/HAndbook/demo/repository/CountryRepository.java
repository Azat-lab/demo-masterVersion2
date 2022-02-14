package com.example.HAndbook.demo.repository;

import com.example.HAndbook.demo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}

