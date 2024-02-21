package ex7.complete;

import java.util.concurrent.CompletableFuture;

public class CFCompleteDemo {
    public static void main(String[] args) {
        //Building pipe-line
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        completableFuture.thenApply(data -> transformData(data))
                .thenAccept(data -> System.out.println("data = " + data))
                .thenRun(() -> System.out.println("Completed!!!"));

        //passing data
        completableFuture.complete(20);
    }

    private static String transformData(Integer data) {
        return "Code: " + data;
    }
}
