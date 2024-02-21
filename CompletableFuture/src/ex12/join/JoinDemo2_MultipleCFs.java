package ex12.join;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JoinDemo2_MultipleCFs {

    static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            sleep(5000);
            System.out.println("Thread execution - " + Thread.currentThread().getName());
            return "Hello-Educative";
        });

        String resultValue = completableFuture.join();

        System.out.println("Result - " + resultValue);

        User user = getUserInfo();
        System.out.println(user);

    }

    private static User getUserInfo() {
        User user = new User();
        User updateCityCF = CompletableFuture.supplyAsync(() -> {
            sleep(5000);
            System.out.println("Thread execution - " + Thread.currentThread().getName());
            user.setCity("City");
            return user;
        }).join();

        User updateNameCF = CompletableFuture.supplyAsync(() -> {
            sleep(5000);
            System.out.println("Thread execution - " + Thread.currentThread().getName());
            user.setName("Name");
            return user;
        }).join();

        return user;
    }
}