package com.ex5.prevent_thread_execution.join.dead_lock;


public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread.mainThread = Thread.currentThread();

        MyThread myThread = new MyThread();
        myThread.start();
        //myThread.join();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
        }
    }
}
