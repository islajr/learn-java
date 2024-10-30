package com.example.student.student.exception;

public class noRegisteredStudentException extends RuntimeException {

    public noRegisteredStudentException() {};

    public noRegisteredStudentException(String msg) {
        super(msg);
    }
}
