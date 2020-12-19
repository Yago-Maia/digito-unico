package com.digito.unico.service;

import java.util.concurrent.Callable;

public class ComputeUniqueDigitTask implements Callable<Integer> {

    private String n;

    public ComputeUniqueDigitTask(String n) {
        this.n = n;
    }

    public Integer call() throws Exception {

        String processedN = n;

        while (processedN.length() > 1) {
            int sum = 0;
            for (int indexDigit = 0; indexDigit < processedN.length(); indexDigit++) {
                sum += Character.getNumericValue(processedN.charAt(indexDigit));
            }

            processedN = String.valueOf(sum);
        }

        return Integer.valueOf(processedN);
    }
}
