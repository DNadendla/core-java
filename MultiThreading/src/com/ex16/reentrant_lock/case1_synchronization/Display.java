package com.ex16.reentrant_lock.case1_synchronization;

import java.util.concurrent.locks.ReentrantLock;

public class Display {
    ReentrantLock reentrantLock = new ReentrantLock();

    public void wish(String name) {
        reentrantLock.lock();
        try {
            MyThread.sleep(100);
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello! " + name);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Deadlock appears if we comment the below code
        reentrantLock.unlock();
    }
}
