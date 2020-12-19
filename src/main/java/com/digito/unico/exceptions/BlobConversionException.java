package com.digito.unico.exceptions;

public class BlobConversionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BlobConversionException() {
        super("An error occurred while N database conversion.");
    }
}
