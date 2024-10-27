package com.test.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice   //annotation to handle multiple exceptions globally
public class PersonExceptionHandler {

    // method to handle the PersonNotFoundException
    @ExceptionHandler(value = {PersonNotFoundException.class})  // annotation to handle specific exception
    public ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException personNotFoundException) {
        PersonException personException = new PersonException(
                personNotFoundException.getMessage(),
                personNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);

        return new ResponseEntity<Object>(personException, HttpStatus.NOT_FOUND);
    }
}
