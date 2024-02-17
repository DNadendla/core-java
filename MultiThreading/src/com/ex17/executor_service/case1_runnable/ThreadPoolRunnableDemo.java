package com.ex17.executor_service.case1_runnable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolRunnableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<PrintJob> printJobs = Arrays.asList(new PrintJob("Sai"), new PrintJob("Rama"),
                new PrintJob("Ramesh"), new PrintJob("Dattasai"), new PrintJob("Rajubabu"));
        //printJobs.forEach(printJob -> executorService.submit(printJob));
        printJobs.forEach(executorService::submit);
        executorService.shutdown();
    }
}
