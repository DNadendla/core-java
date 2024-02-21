package ex1.non_blocking_demo;

import java.util.concurrent.CompletableFuture;

public class NonBlockingExample {
    public static void main(String[] args) {
        System.out.println("Start");
        CompletableFuture.runAsync(() -> {
            // Simulate a non-blocking operation
            try {
                Thread.sleep(2000); // Simulate a long-running task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Async task completed");
        });
        System.out.println("Continuing with other tasks");
        // The main thread continues without waiting for the async task to complete
    }
}
