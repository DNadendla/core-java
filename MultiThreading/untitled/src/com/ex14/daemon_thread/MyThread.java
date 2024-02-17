package com.ex14.daemon_thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Run");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
