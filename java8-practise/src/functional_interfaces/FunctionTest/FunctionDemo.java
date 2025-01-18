package functional_interfaces.FunctionTest;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> lengthFindFunction = (string) -> {return string.length();};
        System.out.println(lengthFindFunction.apply("SAI"));
    }
}
