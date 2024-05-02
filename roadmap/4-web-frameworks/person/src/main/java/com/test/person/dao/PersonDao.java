package com.test.person.dao;
import com.test.person.model.Person;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    // default insertPerson() to run if the method is not overridden
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();    // a random UUID is generated and passed recursively into insertPerson()
        return insertPerson(id, person);
    }

    public Optional<Person> getPerson(UUID id);
    public ArrayList<Person> getAllPersons();
    public int updatePerson(UUID id, Person person);

}
