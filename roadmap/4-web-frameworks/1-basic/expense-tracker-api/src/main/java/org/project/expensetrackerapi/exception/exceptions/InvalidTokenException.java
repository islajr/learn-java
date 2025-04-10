package org.project.expensetrackerapi.exception.exceptions;

public class InvalidTokenException extends RuntimeException {

    String message;

    public InvalidTokenException(String message) {
        super(message);
        this.message = message;
    }
}
