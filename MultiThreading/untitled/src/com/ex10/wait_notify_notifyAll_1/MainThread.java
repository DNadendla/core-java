package com.ex10.wait_notify_notifyAll_1;

public class MainThread {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.start();
        synchronized (threadA) {
            try {
                System.out.println("1. Main Thread calling wait() & enters waiting state");
                threadA.wait();
                System.out.println("4. Main Thread receives notification from child thread");
                System.out.println(threadA.total);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
