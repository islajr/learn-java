package com.test.person.service;

import com.test.person.dao.PersonDao;
import com.test.person.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public Optional<Person> getPerson(UUID id) {
        return personDao.getPerson(id);
    }

    public ArrayList<Person> getAllPersons() {
        return personDao.getAllPersons();
    }
}
