package com.example.demo.domain.exception;

public class NewsNotFoundException extends RuntimeException{
    public NewsNotFoundException(String message){
        super(message);
    }
}
