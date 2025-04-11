package org.project.simpleblogapi.exception.exceptions;

public class AuthenticationFailedException extends RuntimeException {
    private String message;

    public AuthenticationFailedException(String message) {
        super(message);
        this.message = message;
    }
}
