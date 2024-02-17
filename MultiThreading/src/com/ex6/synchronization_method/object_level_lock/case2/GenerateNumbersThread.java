package com.ex6.synchronization_method.object_level_lock.case2;

public class GenerateNumbersThread extends Thread {
    Display display;

    public GenerateNumbersThread(Display display) {
        this.display = display;
    }

    @Override
    public void run() {
        display.displayNumbers();
    }
}
