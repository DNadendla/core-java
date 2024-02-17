package com.ex6.synchronization_method.object_level_lock.case1;

public class Display {
    public synchronized void wish(String name) {
        for (int i = 0; i < 5; i++) {
            System.out.println("GM: "+name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
