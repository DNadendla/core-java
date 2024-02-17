package com.ex7.synchronization_method.class_level_lock;

public class SynchronizedDemo {

    public static void main(String[] args) {
        Display display1 = new Display();
        Display display2 = new Display();
        Display display3 = new Display();

        MyThread myThread1 = new MyThread(display1, "Sai");
        MyThread myThread2 = new MyThread(display2, "Rama");
        MyThread myThread3 = new MyThread(display3, "Krishna");

        myThread1.start();
        myThread2.start();
        myThread3.start();

    }
}
