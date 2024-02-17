package com.ex7.synchronization_method.class_level_lock;

public class MyThread extends Thread {
    public Display display;
    public String message;

    public MyThread(Display display, String message) {
        this.display = display;
        this.message = message;
    }

    @Override
    public void run() {
        display.wish(message);
    }
}
