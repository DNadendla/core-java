package com.ex5.prevent_thread_execution.interrupt;

public class InterruptDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        thread.interrupt();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
        }
    }
}
