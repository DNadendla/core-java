package ex5.thenApply;

import java.util.concurrent.CompletableFuture;

public class CFThenApplyDemo {
    public static void main(String[] args) {
        create(2)
                .thenApply(data -> transformData(data))
                .thenAccept(data -> System.out.println("data = " + data))
                .thenRun(() -> System.out.println("Completed!!!"));
    }

    private static Double transformData(Integer data) {
        return data * 2.0;
    }

    private static CompletableFuture<Integer> create(int val) {
        return CompletableFuture.supplyAsync(() -> val * 2);
    }
}
