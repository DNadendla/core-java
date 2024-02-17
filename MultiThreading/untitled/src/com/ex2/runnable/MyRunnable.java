package com.ex2.runnable;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 1900; i++) {
            System.out.println("child thread");
        }
    }
}
