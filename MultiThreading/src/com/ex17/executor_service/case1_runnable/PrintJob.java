package com.ex17.executor_service.case1_runnable;

public class PrintJob implements Runnable {
    String name;
    PrintJob(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name+" : Job Started by :"+ Thread.currentThread().getName());
    }
}
