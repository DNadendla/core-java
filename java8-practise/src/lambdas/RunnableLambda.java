package com.lambdas;

public class RunnableLambda {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Running data");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
