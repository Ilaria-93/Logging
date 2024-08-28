package com.example.logging.exception;

public class CustomError extends RuntimeException {

    public CustomError(String message) {
        super(message);
    }
}
