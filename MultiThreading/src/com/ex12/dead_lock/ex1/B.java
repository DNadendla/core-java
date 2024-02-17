package com.ex12.dead_lock.ex1;

public class B {

    public synchronized void d2(A a) {
        System.out.println("Thread-2 starts execution of d2() method");
        /*try {
            Thread.sleep(5000);
        } catch (Exception exception) {
        }*/

        System.out.println("Thread-2 tries to call A's last method");
        a.last();
    }

    public synchronized void last() {
        System.out.println("B :: last()");
    }
}
