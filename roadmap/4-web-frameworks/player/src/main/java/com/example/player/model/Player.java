package com.example.player.model;

import java.util.UUID;

public class Player {

    private final UUID id;
    private final String name;
    private final int age;
    private String position;

    public Player(String position, int age, String name, UUID id) {
        this.position = position;
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
