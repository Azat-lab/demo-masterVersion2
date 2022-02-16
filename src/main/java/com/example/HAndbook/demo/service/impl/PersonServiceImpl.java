package com.example.HAndbook.demo.service.impl;


import com.example.HAndbook.demo.entity.Person;
import com.example.HAndbook.demo.exception.PersonNotFoundException;
import com.example.HAndbook.demo.repository.PersonRepository;
import com.example.HAndbook.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
    }
    @Override
    public List<Person> findPersonByPersonName(String personName) {
        return findPersonByPersonLastname(personName);
    }
    @Override
    public List<Person> findPersonByPersonLastname(String person) {
        return findPersonByPersonLastname(person);
    }
    @Override
    public Person findByPersonId(Long personId) {
        Optional<Person> optional = personRepository.findById(Math.toIntExact(personId));
        if(optional.isPresent()){
            return optional.get();
        }else{
        throw new PersonNotFoundException("Person with Id: " + personId);
    }
    }
    @Override
    public void deletePersonById(Long personId) {
        personRepository.deleteById(Math.toIntExact(personId));
    }
}




