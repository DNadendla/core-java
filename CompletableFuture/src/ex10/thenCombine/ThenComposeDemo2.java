package ex10.thenCombine;

import java.util.concurrent.*;
import java.util.function.BiFunction;

public class ThenComposeDemo2 {

    static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void executionThread(){
        System.out.println("Thread execution - " + Thread.currentThread().getName());
    }

    public static void main(String[] args){

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            String stringToPrint = "Educative";
            System.out.println("----\nsupplyAsync first future - " + stringToPrint);
            executionThread();
            return stringToPrint;
        });

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            String stringToPrint = "Edpresso";
            System.out.println("----\nsupplyAsync second future - " + stringToPrint);
            executionThread();
            return stringToPrint;
        });

        BiFunction<String, String, String> stringStringBiFunction = (res1, res2) -> String.format("\"completableFuture1 result - %s | completableFuture2 result - %s\"", res1, res2);
        CompletableFuture<String> finalCompletableFuture = completableFuture1.thenCombine(completableFuture2, stringStringBiFunction);
        System.out.println("Output of thenCombine - " + finalCompletableFuture.join());
        sleep(3000);
    }
}