package com.test.person.api;

import com.test.person.model.Person;
import com.test.person.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private PersonService personService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello there!";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello there, " + name + "!";
    }

    @GetMapping("/person/create")
    public void addPerson(Person person) {
        personService.addPerson(person);
    }

}
