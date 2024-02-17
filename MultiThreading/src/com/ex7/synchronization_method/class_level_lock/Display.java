package com.ex7.synchronization_method.class_level_lock;

public class Display {

    public static synchronized void wish(String name) {
        for (int i = 0; i < 6; i++) {
            System.out.println("Hi: "+name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
