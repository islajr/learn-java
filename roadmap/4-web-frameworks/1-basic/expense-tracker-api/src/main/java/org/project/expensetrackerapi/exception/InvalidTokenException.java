package org.project.expensetrackerapi.exception;

public class InvalidTokenException extends RuntimeException {

    public String message;

    public InvalidTokenException(String message) {
        super(message);
        this.message = message;
    }
}
