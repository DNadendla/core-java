package com.ex3.thread_name;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        thread.setName("Child Thread");
        System.out.println(thread.getName());
        System.out.println("Main: " + Thread.currentThread().getName());
        System.out.println("Priority: " + Thread.currentThread().getPriority());
    }
}
