package ex6.thenRun;

import java.util.concurrent.CompletableFuture;

public class CFThenRun {
    public static void main(String[] args) {
        create()
                .thenAccept(data -> System.out.println("data = " + data))
                //.thenAccept(data -> System.out.println("data = " + data)); //returns null
                .thenRun(() -> System.out.println("Never ends-1"))
                .thenRun(() -> System.out.println("Never ends-2"));
    }

    private static CompletableFuture<Integer> create() {
    return CompletableFuture.supplyAsync(() -> 2);
    }

}
