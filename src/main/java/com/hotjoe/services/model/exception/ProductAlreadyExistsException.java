package com.hotjoe.services.model.exception;

public class ProductAlreadyExistsException extends Exception {
    public ProductAlreadyExistsException() {
        super();
    }

    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
