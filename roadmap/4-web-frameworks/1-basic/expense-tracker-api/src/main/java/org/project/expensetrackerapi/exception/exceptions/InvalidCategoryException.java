package org.project.expensetrackerapi.exception.exceptions;

public class InvalidCategoryException extends RuntimeException {

    String message;

    public InvalidCategoryException(String message) {
        super(message);
        this.message = message;
    }
}
