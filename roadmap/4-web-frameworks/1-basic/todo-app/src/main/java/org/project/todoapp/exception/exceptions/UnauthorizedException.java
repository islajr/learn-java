package org.project.todoapp.exception.exceptions;

public class UnauthorizedException extends RuntimeException {

    String message;

    public UnauthorizedException(String message) {
        super(message);
        this.message = message;
    }
}
