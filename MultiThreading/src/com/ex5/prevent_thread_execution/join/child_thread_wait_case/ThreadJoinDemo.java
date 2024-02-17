package com.ex5.prevent_thread_execution.join.child_thread_wait_case;

public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        //Assigning MainThread
        MyThread.mainThread = Thread.currentThread();

        //Init and assigning Child Thread
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
            Thread.sleep(500);
        }
    }
}
