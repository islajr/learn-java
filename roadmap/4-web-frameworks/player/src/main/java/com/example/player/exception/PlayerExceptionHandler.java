package com.example.player.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlayerExceptionHandler {
    @ExceptionHandler({PlayerNotFoundException.class})
    public ResponseEntity<Object> handlePlayerNotFoundException(PlayerNotFoundException playerNotFoundException){
        PlayerException playerException = new PlayerException(
                playerNotFoundException.getMessage(),
                playerNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(playerException, HttpStatus.NOT_FOUND);
    }
}
