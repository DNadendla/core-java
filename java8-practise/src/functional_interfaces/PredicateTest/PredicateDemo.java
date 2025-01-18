package functional_interfaces.PredicateTest;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> isEvenPredicate = (number) -> {
            return number % 2 == 0;
        };
        System.out.println(isEvenPredicate.test(22));
        System.out.println(isEvenPredicate.test(21));
    }
}
