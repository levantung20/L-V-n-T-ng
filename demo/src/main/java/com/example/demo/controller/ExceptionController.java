package com.example.demo.controller;

import com.example.demo.response.ResponseObject;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseObject emailNotValidatedException(MethodArgumentNotValidException ex, WebRequest request) {
        return new ResponseObject(
                HttpStatus.BAD_REQUEST.value(),
                "Email must be a well-formed",
                null);
    }
    @ExceptionHandler(value = {DuplicateKeyException.class, MongoWriteException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseObject emailDuplicateException(MongoWriteException ex, WebRequest request) {
        return new ResponseObject(
                HttpStatus.BAD_REQUEST.value(),
                "Email has already taken!",
                null);
    }
}
