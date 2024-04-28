package com.test.person.model;

import java.util.UUID;

public class Person {
    private final UUID uuid;
    private String name;


    public Person(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;

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
