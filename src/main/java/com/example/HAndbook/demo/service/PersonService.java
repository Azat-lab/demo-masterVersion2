package com.example.HAndbook.demo.service;

import com.example.HAndbook.demo.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findByPersonName(String personName);//+
    List<Person> findByPersonLastname(String personLastname);
    Optional<Person> findByPersonId(Long personId);//+
    Optional<Person> findByPhoneNumber(Integer phoneNumber);//+
    void deleteByPersonId(Long personId);
    void savePersonById(Long personId);


}
