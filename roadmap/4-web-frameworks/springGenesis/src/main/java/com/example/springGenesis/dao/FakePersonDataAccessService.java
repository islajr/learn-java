package com.example.springGenesis.dao;

import com.example.springGenesis.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personDeletion = selectPersonById(id);
        if (personDeletion.isEmpty()) {
            return 0;
        }
        DB.remove(personDeletion.get());        // else part of the condition
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(p -> {
                    int indexOfPerson = DB.indexOf(p);
                    if (indexOfPerson >= 0) {
                        DB.set(indexOfPerson, new Person(id, person.getName()));
                        return 1;
                    }
                    return 0;       // else part of the condition
                })
                .orElse(0);
    }
}
