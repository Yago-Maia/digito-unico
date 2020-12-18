package com.digito.unico.exceptions;

public class DataBaseOperationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DataBaseOperationException(String message) {
        super(message);
    }
}
