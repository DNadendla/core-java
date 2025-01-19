package streams.operations.map_operations;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSort {
    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("za", 10);
        unsortedMap.put("zb", 5);
        unsortedMap.put("a", 6);
        unsortedMap.put("c", 20);
        unsortedMap.put("d", 1);
        unsortedMap.put("e", 7);
        unsortedMap.put("y", 8);
        unsortedMap.put("n", 99);
        unsortedMap.put("g", 50);
        unsortedMap.put("m", 2);
        unsortedMap.put("f", 9);

        System.out.println("Original...");
        System.out.println(unsortedMap);

        sortByKey(unsortedMap);

        System.out.println("----------");

        sortByKeyDesc(unsortedMap);

        System.out.println("----------");

        sortByValue(unsortedMap);

        System.out.println("----------");

        sortByValueDesc(unsortedMap);

        System.out.println("----------");

        filterAndSort(unsortedMap);
    }

    private static void filterAndSort(Map<String, Integer> unsortedMap) {
        LinkedHashMap<String, Integer> filteredAndSortedMap = unsortedMap.entrySet()
                .stream().filter(entry -> entry.getValue() > 30)
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldV, newV) -> oldV, LinkedHashMap::new));
        filteredAndSortedMap.forEach((name, age) -> System.out.println(name + " " + age));


    }

    private static void sortByValueDesc(Map<String, Integer> unsortedMap) {
        LinkedHashMap<String, Integer> sortByValueDesc = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldV1, newV1) -> oldV1, LinkedHashMap::new));

        sortByValueDesc.forEach((name, age)-> System.out.println(name + " " + age));
    }

    private static void sortByValue(Map<String, Integer> unsortedMap) {
        LinkedHashMap<String, Integer> sortByValue = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldV, newV) -> oldV, LinkedHashMap::new));
        sortByValue.forEach((name,age) -> System.out.println(name + " " + age));
    }

    private static void sortByKeyDesc(Map<String, Integer> unsortedMap) {
        LinkedHashMap<String, Integer> sortedByKeysDesc = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldV, newV) -> oldV, LinkedHashMap::new));
        sortedByKeysDesc.forEach((name, age) -> System.out.println(name + " " + age));
    }

    private static void sortByKey(Map<String, Integer> unsortedMap) {
        LinkedHashMap<String, Integer> sortedByKeys = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldV, newV) -> oldV, LinkedHashMap::new));

        sortedByKeys.forEach((name, age) -> {
            System.out.println(name + " " + age);
        });
    }
}
