package com.test.person.dao;

import com.test.person.model.Person;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonAccessDao implements PersonDao {

    private final PersonRepository personRepository;

    public FakePersonAccessDao(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

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
        return (ArrayList<Person>) personRepository.findAll();
    }

    @Override
    public int updatePerson(UUID id, Person newPerson) {
        return getPerson(id).map(p -> {
            if (db.contains(p)) {
                db.set(db.indexOf(p), new Person(id, newPerson.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    /* the above method works by firstly using the previously-defined getPerson() method that returns a person.
     *
     * the person returned is stored in 'p' and it's position in the arrayList is procured via the .indexOf() method.
     *
     * alternately, the .contains() method can also be used. to verify if that position truly exists in the arrayList.
     *
     * this is a rather weak method of validation, but it works for the purpose of this program.
     *
     * once the condition is met, the element contained in the already-procured index is updated with the .getName() setter and 1 is returned; otherwise, 0 is returned.
     *
     * .orElse() is used after the closing parenthesis to specify what happens if the conditions of the mapping are not met.*/

    @Override
    public int deletePerson(UUID id) {
        for (Person person : db) {
            if (person.getUuid().equals(id)) {
                db.remove(person);
                return 0;
            }
        }

        return 1;
    }
}
