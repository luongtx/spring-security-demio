package com.example.demospringsecurity.exception;

public class AppUserException extends RuntimeException{
    String message;
    public AppUserException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
