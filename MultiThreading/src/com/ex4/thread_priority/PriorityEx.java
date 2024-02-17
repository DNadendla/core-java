package com.ex4.thread_priority;

public class PriorityEx implements Runnable {
    @Override
    public void run() {
        System.out.println("by run()/child thread");
    }

    public static void main(String[] args) {
        int priority = Thread.currentThread().getPriority();
        System.out.println(priority);
        PriorityEx priorityEx = new PriorityEx();
        Thread thread = new Thread(priorityEx);
        System.out.println(thread.getPriority());
        thread.setPriority(1);
        System.out.println(thread.getPriority());
    }
}
