package org.project.simpleblogapi.exception.exceptions;

public class PostAlreadyExistsException extends RuntimeException {

    private String message;

    public PostAlreadyExistsException(String message) {
        this.message = message;
    }
}
