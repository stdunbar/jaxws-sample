package com.hotjoe.services.model.exception;

public class BadProductNameException extends Exception {
    public BadProductNameException() {
        super();
    }

    public BadProductNameException(String message) {
        super(message);
    }
}
