package org.project.todoapp.exception.exceptions;

public class UserNotFoundException extends RuntimeException {

    String message;

    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
