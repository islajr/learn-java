package com.test.person.api;

import com.test.person.model.Person;
import com.test.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/hello")
    public String hello() {
        return "Hello there!";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello there, " + name + "!";
    }

    @PostMapping("/person/create")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping("/person/get-person")
    public Optional<Person> getPerson(@RequestBody UUID id) {
        return personService.getPerson(id);
    }

    @GetMapping("/person/getall")
    public ArrayList<Person> getAllPersons() {
        return personService.getAllPersons();
    }

}
