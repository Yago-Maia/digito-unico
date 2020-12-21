package com.digito.unico.exceptions;

public class ComputeUniqueDigitTaskException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ComputeUniqueDigitTaskException() {
        super("An error occurred while starting tasks to compute unique digit.");
    }
}
