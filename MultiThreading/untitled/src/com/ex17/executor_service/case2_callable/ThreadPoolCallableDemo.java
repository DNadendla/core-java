package com.ex17.executor_service.case2_callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolCallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<FetchSumJob> fetchSumJobs = Arrays.asList(new FetchSumJob(0), new FetchSumJob(1),
                new FetchSumJob(2), new FetchSumJob(3),
        new FetchSumJob(4), new FetchSumJob(5));
        fetchSumJobs.forEach(fetchSumJob -> {
            Future submit = executorService.submit(fetchSumJob);
            try {
                System.out.println("submit = " + submit.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException executionException) {
                System.out.println("ExecutionException = " + executionException.getMessage());
            }
        });
        executorService.shutdown();

    }
}
