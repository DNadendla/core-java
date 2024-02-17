package com.ex9.synchronization_block.class_level_lock;

public class Display {

    public void wish(String message) {

        //Async
        for (int i = 0; i < 25; i++) {
            System.out.println("Start Thread name: " + Thread.currentThread().getName());
        }

        //Sync
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println("Hello: " + message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //Async
        for (int i = 0; i < 50; i++) {
            System.out.println("End Thread name: " + Thread.currentThread().getName());
        }
    }
}
