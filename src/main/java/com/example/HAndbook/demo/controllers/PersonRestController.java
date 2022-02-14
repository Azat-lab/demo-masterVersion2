package com.example.HAndbook.demo.controllers;


import com.example.HAndbook.demo.entity.Person;
import com.example.HAndbook.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons/")
public class PersonRestController {
    private final PersonService personService;
    @Autowired
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

@GetMapping("/persons/personName")
public ResponseEntity<List<Person>> findByPersonName(){
        final List<Person> persons = personService.findByPersonName(findByPersonName().toString());

        return persons != null && !persons.isEmpty()
            ? new ResponseEntity<>(persons, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
    @GetMapping("/persons/personLastname")
    public ResponseEntity<List<Person>> findByLastname(){
        final List<Person> persons = personService.findByPersonLastname(findByLastname().toString());

        return persons != null && !persons.isEmpty()
                ? new ResponseEntity<>(persons, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);}

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> personData = personService.findByPersonId(id);
        return personData.map(person -> new ResponseEntity<>(person, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/persons/number")
    public ResponseEntity<Person> getPersonByNumber(@PathVariable("number") Integer phoneNumber) {
        Optional<Person> personData = personService.findByPhoneNumber(phoneNumber);
        return personData.map(person -> new ResponseEntity<>(person, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/persons")
    @ResponseBody
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        personService.savePersonById(person.getPersonId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/persons{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") Long personId) {
       Optional<Person> person = this.personService.findByPersonId(personId);
       if (person.isPresent()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       this.personService.deleteByPersonId(personId);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
