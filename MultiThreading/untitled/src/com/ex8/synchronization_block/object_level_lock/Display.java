package com.ex8.synchronization_block.object_level_lock;

public class Display {
    public void wish(String name) {
        //Async for this for loop
        for (int i = 0; i < 50; i++) {
            System.out.println("Start Thread Name: " + Thread.currentThread().getName());
        }

        //Sync for this for loop
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println("Hello: " + name);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //Async for this for loop
        for (int i = 0; i < 50; i++) {
            System.out.println("End Thread Name: " + Thread.currentThread().getName());
        }
    }
}
