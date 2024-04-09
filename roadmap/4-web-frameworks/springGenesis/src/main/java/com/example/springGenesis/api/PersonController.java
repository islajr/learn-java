package com.example.springGenesis.api;

import com.example.springGenesis.model.Person;
import com.example.springGenesis.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person) {
        personService.addPerson(person);
    }
}
