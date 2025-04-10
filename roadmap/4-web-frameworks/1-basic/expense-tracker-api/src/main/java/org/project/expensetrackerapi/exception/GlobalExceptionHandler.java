package org.project.expensetrackerapi.exception;

import org.project.expensetrackerapi.exception.exceptions.ArgumentOverflowException;
import org.project.expensetrackerapi.exception.exceptions.InvalidCategoryException;
import org.project.expensetrackerapi.exception.exceptions.InvalidTokenException;
import org.project.expensetrackerapi.exception.exceptions.NoArgumentProvidedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = InvalidTokenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody ErrorResponse handleException(InvalidTokenException e) {
        return new ErrorResponse(HttpStatus.FORBIDDEN.value(), e.getMessage());
    }

    @ExceptionHandler(value = ArgumentOverflowException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(ArgumentOverflowException e) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(value = NoArgumentProvidedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(NoArgumentProvidedException e) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(value = InvalidCategoryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(InvalidCategoryException e) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

}
