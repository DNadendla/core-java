package com.ex14.daemon_thread;

public class DaemonDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setDaemon(true);
        System.out.println(myThread.isDaemon());
    }
}
