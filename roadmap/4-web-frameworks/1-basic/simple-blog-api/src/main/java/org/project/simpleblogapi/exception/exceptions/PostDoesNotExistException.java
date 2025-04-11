package org.project.simpleblogapi.exception.exceptions;

public class PostDoesNotExistException extends RuntimeException {

    private String message;

    public PostDoesNotExistException(String message) {
        super(message);
        this.message = message;
    }
}
