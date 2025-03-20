package org.project.simpleblogapi.exception;

public class ErrorResponse {

    int statusCode;
    String message;

    public ErrorResponse(String message) {
        super();
        this.message = message;
    }

    public ErrorResponse(int statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }
}
