package org.project.expensetrackerapi.exception.exceptions;

public class ArgumentOverflowException extends RuntimeException {

    String message;

    public ArgumentOverflowException(String message) {
        super(message);
        this.message = message;
    }
}
