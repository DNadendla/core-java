package streams.operations.list_set_map_operations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTerminalOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 3, 5, 1, 6);
        //collect , count, anyMatch, reduce
        List<Integer> integers = numbers.stream()
                .map(num -> num * 10)
                .collect(Collectors.toList());
        System.out.println(integers);

        Set<Integer> intMaps = numbers.stream()
                .map(num -> num * 10)
                .collect(Collectors.toSet());
        System.out.println(intMaps);

        long count = numbers.stream().distinct().count();
        System.out.println(count);

        boolean anyGreaterThan2 = numbers.stream().anyMatch(num -> num > 20);
        System.out.println("Number greater than 20? " + anyGreaterThan2);

        int sum = numbers.stream()
                .reduce(0, Integer :: sum);
        System.out.println(sum);

    }

    private static void distinctList(List<Integer> data) {
        Stream<Integer> distincted = data.stream().distinct();
        System.out.println(distincted);
    }

    private static void sortDesc(List<Integer> data) {
        List<Integer> sortedByDesc = data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedByDesc);
    }

    private static void sort(List<Integer> data) {
        List<Integer> sorted = data.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);
    }

}
