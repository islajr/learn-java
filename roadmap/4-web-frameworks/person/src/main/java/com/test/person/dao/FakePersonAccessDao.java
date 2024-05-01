package com.test.person.dao;

import com.test.person.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonAccessDao implements PersonDao{

    private static ArrayList<Person> db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public Optional<Person> getPerson(UUID id) {
        return db.stream()
                .filter(person -> person.getUuid().equals(id))
                .findFirst();
    }

    @Override
    public ArrayList<Person> getAllPersons() {
        return db;
    }

}
