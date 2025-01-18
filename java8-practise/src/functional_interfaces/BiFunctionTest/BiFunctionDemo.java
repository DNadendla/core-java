package functional_interfaces.BiFunctionTest;

import java.util.function.BiFunction;

public class BiFunctionDemo {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> additionBiFunction = (val1, val2) -> {
            return val1 + val2;
        };
        System.out.println(additionBiFunction.apply(1,1));
        System.out.println(additionBiFunction.apply(1,2));
    }
}
