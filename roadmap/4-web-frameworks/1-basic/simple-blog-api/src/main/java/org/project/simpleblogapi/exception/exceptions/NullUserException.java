package org.project.simpleblogapi.exception.exceptions;

public class NullUserException extends RuntimeException {

    private String message;

    public NullUserException(String message) {
        this.message = message;
    }
}
