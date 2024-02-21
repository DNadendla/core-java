package ex3.get;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CFGet {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer result = create().get(); //blocking call -> waits till the execution is completed
        System.out.println("result = " + result);
        System.out.println("executed after printing result");
    }

    private static CompletableFuture<Integer> create() {
    return CompletableFuture.supplyAsync(() -> {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 2;
    });
    }

}
