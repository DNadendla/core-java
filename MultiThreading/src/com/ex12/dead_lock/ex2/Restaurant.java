package com.ex12.dead_lock.ex2;

public class Restaurant {

    public synchronized void orderFood(Brewery brewery) {
        System.out.println("Thread-1 starts execution of orderFood() method");
        try {
            Thread.sleep(2000);
        } catch (Exception exception) {
        }

        System.out.println("Thread-1 tries to call Brewery's last method");
        brewery.processOrder();
    }

    public synchronized void processOrder() {
        System.out.println("Restaurant :: last()");
    }

}
