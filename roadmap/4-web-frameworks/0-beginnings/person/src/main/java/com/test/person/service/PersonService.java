package com.test.person.service;

import com.test.person.dao.PersonDao;
import com.test.person.exception.PersonNotFoundException;
import com.test.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public Optional<Person> getPerson(UUID id) {
        if (personDao.getPerson(id).isEmpty())
            throw new PersonNotFoundException("This person does not exist");
        return personDao.getPerson(id);
    }

    public ArrayList<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    public int updatePerson(UUID id, Person person) {
        return personDao.updatePerson(id, person);
    }

    public int removePerson(UUID id) {
        return personDao.deletePerson(id);
    }
}
