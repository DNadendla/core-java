package ex11.thenCompose;

import java.util.concurrent.CompletableFuture;

public class ThenComposeDemo {
    public static void main(String[] args) {
        create(2)
                //.thenApply(data -> increment(data)) => Not suitable as increment returns another CF
                .thenCompose(data -> increment(data)) // to flatten the CF result, we use thenCompose
                .thenAccept(data -> System.out.println(data));
    }

    private static CompletableFuture<Integer> increment(Integer data) {
        return CompletableFuture.supplyAsync(() -> data + 1);
    }

    private static CompletableFuture<Integer> create(int i) {
        return CompletableFuture.supplyAsync(() -> i * 2);
    }
}
