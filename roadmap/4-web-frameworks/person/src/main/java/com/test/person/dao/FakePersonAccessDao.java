package com.test.person.dao;

import com.test.person.model.Person;

import java.util.ArrayList;
import java.util.UUID;

public class FakePersonAccessDao implements PersonDao{

    private static ArrayList<Person> db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public Person getPerson(UUID id) {
        return null;
    }

}
