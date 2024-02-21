package ex8.CFThreadAnalysis;

import java.util.concurrent.CompletableFuture;

public class CFThreadAnalysis {
    public static void main(String[] args) {
        System.out.println("main() :: Executed by "+ Thread.currentThread());
        CompletableFuture<Integer> future = create();
        future.thenAccept(data -> printIt(data));
    }

    private static void printIt(Integer data) {
        System.out.println("print() :: data = " + data+", Executed by "+ Thread.currentThread());
    }

    private static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("create() :: executed by "+ Thread.currentThread());
            return 2;
        });
    }
}
