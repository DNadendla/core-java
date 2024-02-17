package com.ex12.dead_lock.ex1;

public class DeadLockDemo extends Thread {
    A a = new A();
    B b = new B();

    public void m1() {
        //Starting Thread
        this.start();
        a.d1(b); //Main Thread Execution
    }

    @Override
    public void run() {
        b.d2(a); //Child Thread Execution
    }

    public static void main(String[] args) {
        DeadLockDemo deadLockDemo = new DeadLockDemo();
        deadLockDemo.m1();
    }
}
