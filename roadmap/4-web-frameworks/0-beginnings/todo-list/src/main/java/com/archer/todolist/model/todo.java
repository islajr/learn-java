package com.archer.todolist.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table

public class todo {
    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )

    int id;
    String name;
    LocalDateTime timeIssued;
    Boolean isCompleted;
    LocalDateTime timeTaken;

    public todo(int id, String name, LocalDateTime timeIssued, Boolean isCompleted, LocalDateTime timeTaken) {
        this.id = id;
        this.name = name;
        this.timeIssued = timeIssued;
        this.isCompleted = isCompleted;
        this.timeTaken = timeTaken;
    }

    public todo(String name) {
        this.name = name;
    }

    public todo(String name, LocalDateTime timeIssued) {
        this.name = name;
        this.timeIssued = timeIssued;
    }

    public todo() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTimeIssued() {
        return timeIssued;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public LocalDateTime getTimeTaken() {
        return timeTaken;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeIssued(LocalDateTime timeIssued) {
        this.timeIssued = timeIssued;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public void setTimeTaken(LocalDateTime timeTaken) {
        this.timeTaken = timeTaken;
    }
}
