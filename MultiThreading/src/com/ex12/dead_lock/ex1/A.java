package com.ex12.dead_lock.ex1;

public class A {

    public synchronized void d1(B b) {
        System.out.println("Thread-1 starts execution of d1() method");
       /* try {
            Thread.sleep(2000);
        } catch (Exception exception) {
        }*/

        System.out.println("Thread-1 tries to call B's last method");
        b.last();
    }

    public synchronized void last() {
        System.out.println("A :: last()");
    }

}
