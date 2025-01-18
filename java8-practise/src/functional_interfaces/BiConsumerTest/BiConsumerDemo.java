package functional_interfaces.BiConsumerTest;

import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer<String, String> stringBiConsumer = (str1, str2) -> {
            System.out.println(str1 +" "+str2);
        };
        stringBiConsumer.accept("GM","Hello");
    }
}
