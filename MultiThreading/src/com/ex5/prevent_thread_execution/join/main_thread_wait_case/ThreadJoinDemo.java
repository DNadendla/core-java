package com.ex5.prevent_thread_execution.join.main_thread_wait_case;

public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
        }
    }
}
