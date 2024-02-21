package ex12.join;

import java.util.concurrent.*;

public class JoinDemo1 {

    static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            System.out.println("Thread execution - " + Thread.currentThread().getName());
            return "Hello-Educative";
        });

        String resultValue = completableFuture.join();

        System.out.println("Result - " + resultValue);
    }

}