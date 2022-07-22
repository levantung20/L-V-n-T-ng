package com.example.demo.domain.exception.handler;

import com.example.demo.domain.exception.NewsNotFoundException;
import com.example.demo.response.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NewsNotFoundExceptionHandler {
    @ExceptionHandler(NewsNotFoundException.class)
    public ResponseEntity<ResponseObject> handler(NewsNotFoundException newsNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject(HttpStatus.NOT_FOUND.value(), newsNotFoundException.getMessage(), null));
    }
}
