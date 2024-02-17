package com.ex6.synchronization_method.object_level_lock.case2;

public class Display {

    /**
     * Use Thread.sleep to showcase the Simultaneous execution of thread
     */
    public synchronized void displayNumbers() {
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(i);
        }
    }

    public synchronized void displayCharacters() {
        for (int i = 65; i < 71; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print((char) i);
        }
    }
}
