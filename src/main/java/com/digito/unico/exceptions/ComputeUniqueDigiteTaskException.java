package com.digito.unico.exceptions;

public class ComputeUniqueDigiteTaskException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ComputeUniqueDigiteTaskException() {
        super("An error occurred while starting tasks to compute unique digit.");
    }
}
