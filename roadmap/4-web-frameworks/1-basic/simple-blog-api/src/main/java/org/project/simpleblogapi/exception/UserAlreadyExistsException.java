package org.project.simpleblogapi.exception;

public class UserAlreadyExistsException extends RuntimeException {

    private String message;

    public UserAlreadyExistsException(String message) {
        this.message = message;
    }
}
