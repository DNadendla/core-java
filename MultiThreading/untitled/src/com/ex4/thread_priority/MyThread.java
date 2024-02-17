package com.ex4.thread_priority;

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("child thread");
        }
    }
}