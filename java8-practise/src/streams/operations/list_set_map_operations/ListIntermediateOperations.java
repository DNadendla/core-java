package streams.operations.list_set_map_operations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListIntermediateOperations {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,2,12,34,44,55,44,32);
        //intermediate operations
        sort(data);
        System.out.println("----------");
        sortDesc(data);
        System.out.println("----------");
        distinctList(data);
    }

    private static void distinctList(List<Integer> data) {
        List<Integer> distinct = data.stream()
                                         .distinct()
                                         .collect(Collectors.toList());
        System.out.println(distinct);
    }

    private static void sortDesc(List<Integer> data) {
        List<Integer> sortedByDesc = data.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedByDesc);
    }

    private static void sort(List<Integer> data) {
        List<Integer> sorted = data.stream()
                                    .sorted()
                                    .collect(Collectors.toList());
        System.out.println(sorted);
    }

}
