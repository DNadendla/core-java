package com.ex8.synchronization_block.object_level_lock;

public class MyThread extends Thread {
    Display display;
    String name;

    public MyThread(Display display, String name) {
        this.display = display;
        this.name = name;
    }

    @Override
    public void run() {
        display.wish(name);
    }
}
