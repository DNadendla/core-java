package com.ex16.reentrant_lock.case1_synchronization;

public class MyThread extends Thread {

    public Display display;
    public String name;

    public MyThread(Display display, String name) {
        this.display = display;
        this.name = name;
    }

    @Override
    public void run() {
        display.wish(name);
    }
}
