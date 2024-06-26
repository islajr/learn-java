package com.archer.todolist.model;

import java.time.LocalDateTime;

public class todo {

    String name;
    LocalDateTime timeIssued;
    Boolean isCompleted;
    LocalDateTime timeTaken;

    public todo(String name, LocalDateTime timeIssued, Boolean isCompleted, LocalDateTime timeTaken) {
        this.name = name;
        this.timeIssued = timeIssued;
        this.isCompleted = isCompleted;
        this.timeTaken = timeTaken;
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
