package com.ex5.prevent_thread_execution.join.child_thread_wait_case;

public class MyThread extends Thread {

    //Main/Parent Thread
    public static Thread mainThread;
    @Override
    public void run() {
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread");
        }
    }
}
