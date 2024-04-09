package com.example.springGenesis.service;

import com.example.springGenesis.dao.PersonDao;
import com.example.springGenesis.model.Person;

public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
}
