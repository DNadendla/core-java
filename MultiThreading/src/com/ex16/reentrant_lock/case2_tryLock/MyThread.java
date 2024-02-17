package com.ex16.reentrant_lock.case2_tryLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }
    static Lock lock = new ReentrantLock();
    @Override
    public void run() {
    if (lock.tryLock()) {
        System.out.println("lock acquired by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.unlock();
    } else {
        System.out.println("lock not available for " + Thread.currentThread().getName());
    }
    }
}
