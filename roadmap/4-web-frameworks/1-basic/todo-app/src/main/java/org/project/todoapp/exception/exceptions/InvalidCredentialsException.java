package org.project.todoapp.exception.exceptions;

public class InvalidCredentialsException extends RuntimeException {

    String message;

    public InvalidCredentialsException(String message) {
        super(message);
        this.message = message;
    }
}
