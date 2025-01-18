package functional_interfaces.BiPredicateTest;

import java.util.function.BiPredicate;

public class BiPredicateDemo {
    public static void main(String[] args) {
        BiPredicate<String, String> matchingStringsPredicate = (name1, name2) -> {
            return name1.equals(name2);
        };
        System.out.println(matchingStringsPredicate.test("ABC", "ABC"));
        System.out.println(matchingStringsPredicate.test("ABC", "abc"));
    }
}
