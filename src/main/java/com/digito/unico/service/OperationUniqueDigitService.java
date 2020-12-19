package com.digito.unico.service;

import com.digito.unico.exceptions.ComputeUniqueDigiteTaskException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class OperationUniqueDigitService {
    public int computeUniqueDigit(String n, int k) {
        return getUniqueDigit(String.valueOf(k * getUniqueDigit(n)));
    }

    public int getUniqueDigit(String n) {
        //serao utilizadas 4 threads para computar o digito unico de cada partição da String N

        int lenPartition = n.length() % 4 == 0 ? n.length() / 4 : (int) Math.ceil((double) n.length() / 4) ;

        List<String> substrings = getSubstrings(lenPartition, n);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> listTasks = new ArrayList<>();

        for(String subs: substrings) {
            listTasks.add(new ComputeUniqueDigitTask(subs));
        }

        int result = 0;
        try {
            List<Future<Integer>> tasks = executorService.invokeAll(listTasks);
            for(Future<Integer> task : tasks) {
                result+= task.get();
            }
        } catch (Exception e) {
            throw new ComputeUniqueDigiteTaskException();
        }

        String strResult = String.valueOf(result);

        if(strResult.length() > 1) {
            return getUniqueDigit(strResult);
        } else {
            return Integer.parseInt(strResult);
        }
    }

    public List<String> getSubstrings(int len, String n) {
        List<String> strings = new ArrayList<>();
        int index = 0;
        while (index < n.length()) {
            strings.add(n.substring(index, Math.min(index + len, n.length())));
            index+= len;
        }

        return strings;
    }
}
