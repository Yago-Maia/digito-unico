package com.digito.unico.exceptions;

public class FieldValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FieldValidationException(String message) {
        super(message);
    }

}