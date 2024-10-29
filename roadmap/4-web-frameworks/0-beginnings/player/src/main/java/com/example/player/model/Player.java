                package com.example.player.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
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

    public void setPosition(String position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}