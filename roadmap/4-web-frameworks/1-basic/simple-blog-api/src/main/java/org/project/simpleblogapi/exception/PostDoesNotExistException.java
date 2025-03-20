package org.project.simpleblogapi.exception;

public class PostDoesNotExistException extends RuntimeException {

    private String message;

    public PostDoesNotExistException(String message) {
        super(message);
        this.message = message;
    }
}
