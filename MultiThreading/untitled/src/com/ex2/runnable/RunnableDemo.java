package com.ex2.runnable;

public class RunnableDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        for (int i=1; i<=1000; i++) {
            System.out.println("main thread");
        }
    }
}
