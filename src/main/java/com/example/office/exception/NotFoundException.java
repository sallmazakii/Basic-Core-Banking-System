package com.example.office.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String msg)
    {
        super(msg);
    }
}
