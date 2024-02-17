package com.ex10.wait_notify_notifyAll_1;

public class ThreadA extends Thread {
    int total = 0;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("2. Received Lock, Child thread starts calculation");
            for (int i = 0; i < 100; i++) {
                total = total + i;
            }
            //this.notify();
            System.out.println("3. Child thread gives notification");

        }
    }
}
