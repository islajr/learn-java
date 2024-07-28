package com.example.player.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;
    private int age;
    private String position;

    public Player(String position, int age, String name, Long id) {
        this.position = position;
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public Player(Long id, String name, int age) {

        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Player() {

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
