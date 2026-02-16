package streams.practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Sechigh {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 35, 50, 50, 75, 65);
        Optional<Integer> first = numbers.stream().distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println(first.get());

    }
}
