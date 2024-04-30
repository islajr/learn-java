package com.test.person.service;

import com.test.person.dao.PersonDao;
import com.test.person.model.Person;

public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
}
