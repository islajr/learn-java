package com.example.student.student.exception;

public class studentDoesNotExistException extends RuntimeException {
    
    private String message;

    // constructors
    public studentDoesNotExistException() {};

    public studentDoesNotExistException(String msg) {
        super(msg);
        this.message = msg;
    }

}
