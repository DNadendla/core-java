package com.ex16.reentrant_lock.case1_synchronization;

public class ReentrantDemo {
    public static void main(String[] args) {
        Display display = new Display();
        MyThread myThread1 = new MyThread(display, "Sai");
        MyThread myThread2 = new MyThread(display, "Rameshbabu");
        MyThread myThread3 = new MyThread(display, "mahesh");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
