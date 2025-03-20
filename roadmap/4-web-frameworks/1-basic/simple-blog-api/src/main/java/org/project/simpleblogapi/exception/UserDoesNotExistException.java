package org.project.simpleblogapi.exception;

public class UserDoesNotExistException extends RuntimeException {

    private String message;

    public UserDoesNotExistException(String message) {
        super(message);
        this.message = message;
    }
}
