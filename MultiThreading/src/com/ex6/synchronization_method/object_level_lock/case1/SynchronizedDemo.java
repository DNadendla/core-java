package com.ex6.synchronization_method.object_level_lock.case1;

public class SynchronizedDemo {
    public static void main(String[] args) {
        Display display = new Display();
        MyThread myThread1 = new MyThread(display, "Sai");
        MyThread myThread2 = new MyThread(display, "Rama");
        MyThread myThread3 = new MyThread(display, "Rajesh");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
