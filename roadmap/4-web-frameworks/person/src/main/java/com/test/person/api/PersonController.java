package com.test.person.api;

import com.test.person.model.Person;
import com.test.person.service.PersonService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/person/create")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

}
