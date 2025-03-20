package org.project.simpleblogapi.exception;

public class PostAlreadyExistsException extends RuntimeException {

    private String message;

    public PostAlreadyExistsException(String message) {
        this.message = message;
    }
}
