package ex2.demo;

import java.util.concurrent.CompletableFuture;

public class completableFutureDemo {
    public static void main(String[] args) {
        create()
                .thenAccept(data -> System.out.println("data = " + data));
    }

    private static CompletableFuture<Integer> create() {
    return CompletableFuture.supplyAsync(() -> 2);
    }

}
