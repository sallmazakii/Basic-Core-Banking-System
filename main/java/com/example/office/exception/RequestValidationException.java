package com.example.office.exception;

public class RequestValidationException extends RuntimeException{
    public RequestValidationException(String message) {
        super(message);
    }
}
