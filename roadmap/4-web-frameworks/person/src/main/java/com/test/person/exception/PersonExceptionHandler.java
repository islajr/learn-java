package com.test.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PersonExceptionHandler {

    // method to handle the PersonNotFoundException
    public ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException personNotFoundException) {
        PersonException personException = new PersonException(
                personNotFoundException.getMessage(),
                personNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);

        return new ResponseEntity<Object>(personException, HttpStatus.NOT_FOUND);
    }
}
