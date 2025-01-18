package functional_interfaces.CosumerTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> printConsumer = (message) -> {
            System.out.println("Printing Message -> " + message);
        };
        printConsumer.accept("Hello");

        List<Integer> numbers = new ArrayList<>();
        Consumer<Integer> addToList = number -> numbers.add(number);
        addToList.accept(5);
        System.out.println(numbers); // Output: [5]
    }
}
