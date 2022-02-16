package com.example.HAndbook.demo.service;

import com.example.HAndbook.demo.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> findPersonByPersonName(String personName);//+
    List<Person> findPersonByPersonLastname(String personLastname);
    Person findByPersonId(Long personId);//+
    void deletePersonById(Long personId);
    void createPerson(Person person);
}
