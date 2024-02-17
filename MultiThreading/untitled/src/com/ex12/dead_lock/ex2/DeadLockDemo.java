package com.ex12.dead_lock.ex2;

public class DeadLockDemo extends Thread {
    Restaurant restaurant = new Restaurant();
    Brewery brewery = new Brewery();

    public void m1() {
        //Starting Thread
        this.start();
        restaurant.orderFood(brewery); //Main Thread Execution
    }

    @Override
    public void run() {
        brewery.orderBeer(restaurant); //Child Thread Execution
    }

    public static void main(String[] args) {
        DeadLockDemo deadLockDemo = new DeadLockDemo();
        deadLockDemo.m1();
    }
}
