package com.ex16.reentrant_lock.case2_tryLock;

public class TryLockDemo {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("Ram");
        MyThread myThread2 = new MyThread("Sai");
        myThread2.start();
        myThread1.start();
    }
}
