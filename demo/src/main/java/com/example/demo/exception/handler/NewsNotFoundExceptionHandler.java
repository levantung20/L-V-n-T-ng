package com.example.demo.exception.handler;

import com.example.demo.exception.NewsNotFoundException;
import com.example.demo.response.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NewsNotFoundExceptionHandler {
    @ExceptionHandler(NewsNotFoundException.class)
<<<<<<< HEAD
    public ResponseEntity<ResponseObject> handler(NewsNotFoundException newsNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject(HttpStatus.NOT_FOUND.value(), newsNotFoundException.getMessage(), null));
=======
    public ResponseEntity<ResponseObject> handler(NewsNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject(HttpStatus.NOT_FOUND.value(), e.getMessage(), null));
>>>>>>> 358ae60dc6193a99e8c28c9eba1eb2d025fc55f9
    }
}
