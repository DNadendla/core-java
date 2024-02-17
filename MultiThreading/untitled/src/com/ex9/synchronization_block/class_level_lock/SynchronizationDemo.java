package com.ex9.synchronization_block.class_level_lock;

public class SynchronizationDemo {
    public static void main(String[] args) {
        Display display1 = new Display();
        Display display2 = new Display();
        MyThread myThread1 = new MyThread(display1, "Sai");
        MyThread myThread2 = new MyThread(display2, "Rama");
        myThread1.start();
        myThread2.start();
    }
}
