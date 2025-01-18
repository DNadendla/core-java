package ex1.concurrent_modification_exception;

import java.util.Arrays;
import java.util.List;

public class ConcurrentModificationExceptionDemo {
    public static void main(String[] args) {
        List list = Arrays.asList("A", "B", "C");

        list.forEach(element -> {
            System.out.println(element);
            list.add("D");
        });
    }
}