package org.project.expensetrackerapi.exception.exceptions;

public class NoArgumentProvidedException extends RuntimeException {

    String message;

    public NoArgumentProvidedException(String message) {
        super(message);
        this.message = message;
    }
}
