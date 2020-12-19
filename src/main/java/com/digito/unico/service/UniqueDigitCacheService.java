package com.digito.unico.service;

import com.digito.unico.domain.UniqueDigit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniqueDigitCacheService {
    private static List<UniqueDigit> uniqueDigitQueue = new ArrayList<>();

    public void insertUniqueDigit(UniqueDigit uniqueDigit) {
        boolean aux = isFull();

        if (aux) {
            deleteUniqueDigit();
        }
        uniqueDigitQueue.add(uniqueDigit);
    }

    public UniqueDigit getFromQueue(String n, int k) {

        if (!uniqueDigitQueue.isEmpty()) {
            for (UniqueDigit uniqueDigit : uniqueDigitQueue) {
                if (uniqueDigit.getK() == k && uniqueDigit.getN().equals(n)) {
                    return uniqueDigit;
                }
            }
        }

        return null;
    }

    public void deleteUniqueDigit() {
        uniqueDigitQueue.remove(0);
    }

    public boolean isFull() {
        return uniqueDigitQueue.size() == 10;
    }
}
