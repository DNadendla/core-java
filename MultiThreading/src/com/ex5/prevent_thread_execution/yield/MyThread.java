package com.ex5.prevent_thread_execution.yield;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            Thread.yield();
            System.out.println("child thread");
        }
    }
}
