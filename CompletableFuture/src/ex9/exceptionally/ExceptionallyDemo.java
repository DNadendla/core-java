package ex9.exceptionally;

import java.util.concurrent.CompletableFuture;

public class ExceptionallyDemo {
    public static void main(String[] args) {
        create(0)
                .thenApply(ExceptionallyDemo::processData)
                .exceptionally(throwable -> handleException(throwable))
                .thenAccept(ExceptionallyDemo::printData)
                .thenRun(() -> System.out.println("Completed Action!!!"))
                .exceptionally(throwable -> testHandleException(throwable));
    }

    private static int handleException(Throwable throwable) {
        System.out.println("Issues to process request: "+throwable.getMessage());
        return -1;
    }

    private static Void testHandleException(Throwable throwable) {
        System.out.println("Issues to process request: "+throwable.getMessage());
        return null;
    }

    private static void printData(Integer integer) {
        System.out.println("Received: " + integer);
    }

    private static int processData(Integer integer) {
        if (integer == 0) throw new RuntimeException("Invalid Data");
        return integer * 20;
    }

    private static CompletableFuture<Integer> create(int val) {
        return CompletableFuture.supplyAsync(() -> val);
    }
}
