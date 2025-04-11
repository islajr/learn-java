package org.project.simpleblogapi.exception.exceptions;

public class UserDoesNotExistException extends RuntimeException {

    private String message;

    public UserDoesNotExistException(String message) {
        super(message);
        this.message = message;
    }
}
