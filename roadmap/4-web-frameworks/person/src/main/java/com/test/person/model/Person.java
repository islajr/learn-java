package com.test.person.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Person {
    @Id
    @SequenceGenerator(
            name="person_sequence",
            sequenceName="person_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private UUID uuid;
    private String name;


    public Person(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;

    }

    public Person() {

    }


    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }
}
