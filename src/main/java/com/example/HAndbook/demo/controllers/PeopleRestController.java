package com.example.HAndbook.demo.controllers;


import com.example.HAndbook.demo.entity.Person;
import com.example.HAndbook.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PeopleRestController {
    @Autowired
     private PersonService personService;

//    public PeopleRestController(PersonService personService) {
//        this.personService = personService;
//    }

@GetMapping("/name")
public ResponseEntity<List<Person>> findPersonByPersonName(){
        List<Person> persons =personService.findPersonByPersonName(String.valueOf(true));
        if(persons.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(persons, HttpStatus.OK);
}
    @GetMapping("/lastname")
    public ResponseEntity<List<Person>> findPersonByLastname(){
        List<Person> persons =personService.findPersonByPersonLastname(String.valueOf(true));
        if(persons.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(persons, HttpStatus.OK);}

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> personData = Optional.ofNullable(personService.findByPersonId(id));
        return personData.map(person -> new ResponseEntity<>(person, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Person> createPerson(@RequestBody @Validated Person person) {
    personService.createPerson(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePersonById(@PathVariable("id") Long personId) {
       Optional<Person> person = Optional.ofNullable(this.personService.findByPersonId(personId));
       if (person.isPresent()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       this.personService.deletePersonById(personId);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
