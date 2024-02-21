package ex4.thenAccept;

import java.util.concurrent.CompletableFuture;

public class CFThenAccept {
    public static void main(String[] args) {
        create()
                .thenAccept(data -> System.out.println("data = " + data));
    }

    private static CompletableFuture<Integer> create() {
    return CompletableFuture.supplyAsync(() -> 2);
    }

}
