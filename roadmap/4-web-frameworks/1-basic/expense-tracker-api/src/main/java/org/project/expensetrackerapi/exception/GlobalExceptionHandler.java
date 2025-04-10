package org.project.expensetrackerapi.exception;

import org.project.expensetrackerapi.exception.exceptions.ArgumentOverflowException;
import org.project.expensetrackerapi.exception.exceptions.InvalidCategoryException;
import org.project.expensetrackerapi.exception.exceptions.InvalidTokenException;
import org.project.expensetrackerapi.exception.exceptions.NoArgumentProvidedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = InvalidTokenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<String> handleException(InvalidTokenException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }

    @ExceptionHandler(value = ArgumentOverflowException.class)
    public ResponseEntity<String> handleException(ArgumentOverflowException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = NoArgumentProvidedException.class)
    public ResponseEntity<String> handleException(NoArgumentProvidedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


    @ExceptionHandler(value = InvalidCategoryException.class)
    public ResponseEntity<String> handleException(InvalidCategoryException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
