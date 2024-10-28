package com.example.student.student.exception;

public class studentAlreadyExistsException extends RuntimeException {
    
    private String message;

    public studentAlreadyExistsException() {};

    public studentAlreadyExistsException(String msg) {

        super(msg);
        this.message = msg;

    }


}
