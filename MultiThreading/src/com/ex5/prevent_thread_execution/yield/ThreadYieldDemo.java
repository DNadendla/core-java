package com.ex5.prevent_thread_execution.yield;


public class ThreadYieldDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i=0; i<10; i++) {
            System.out.println("Main Thread");
        }
    }
}
