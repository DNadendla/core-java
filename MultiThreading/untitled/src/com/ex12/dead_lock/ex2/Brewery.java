package com.ex12.dead_lock.ex2;

public class Brewery {

    public synchronized void orderBeer(Restaurant restaurant) {
        System.out.println("Thread-2 starts execution of orderBeer() method");
        try {
            Thread.sleep(5000);
        } catch (Exception exception) {
        }
        System.out.println("Thread-2 tries to call Restaurant's last method");
        restaurant.processOrder();
    }

    public synchronized void processOrder() {
        System.out.println("Brewery :: last()");
    }
}
