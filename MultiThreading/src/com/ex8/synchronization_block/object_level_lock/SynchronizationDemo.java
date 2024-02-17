package com.ex8.synchronization_block.object_level_lock;

public class SynchronizationDemo {
    public static void main(String[] args) {
        Display display = new Display();
        MyThread myThread1 = new MyThread(display, "Mahi");
        MyThread myThread2 = new MyThread(display, "Ram");
        myThread1.start();
        myThread2.start();
    }
}
