package com.example.player.model;

import jakarta.persistence.*;


import java.util.Collection;
import java.util.List;

@Entity
@Table
public class Player {

    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence")
    private Long id;
    private String name;
    private Integer age;
    private String position;

    public Player(String position, Integer age, String name, Long id) {
        this.position = position;
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public Player(Long id, String name, Integer age) {

        this.id = id;
        this.name = name;
        this.age = age;
    }

    protected Player() {

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

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}