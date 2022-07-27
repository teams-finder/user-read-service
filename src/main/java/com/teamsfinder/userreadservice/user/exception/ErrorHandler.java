package com.teamsfinder.userreadservice.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
class ErrorHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErroResponse handleUserNotFoundException(UserNotFoundException exception){
        return new ErroResponse(HttpStatus.NOT_FOUND.toString(),
                exception.getMessage(), LocalDateTime.now());
    }
}
