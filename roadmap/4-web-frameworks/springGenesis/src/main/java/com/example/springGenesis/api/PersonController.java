package com.example.springGenesis.api;

import com.example.springGenesis.model.Person;
import com.example.springGenesis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping        // serving this request as a POST request
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping     // serving this request as a GET request
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
}
