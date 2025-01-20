package streams.operations.map_advance;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<Student, Integer> studentMap = new HashMap<>();
        studentMap.put(new Student(3, "Alice", 20), 85);
        studentMap.put(new Student(1, "Bob", 22), 90);
        studentMap.put(new Student(2, "Charlie", 21), 88);

        studentMap.forEach((student, score) -> System.out.println(student + " " + score));

        Map<Student, Integer> sortedMap = studentMap.entrySet()
                .stream()
                //.sorted(Map.Entry.comparingByKey(Comparator.comparing(Student::getId)))
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Student::getId, Comparator.reverseOrder())))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        System.out.println("----------");

        sortedMap.forEach((student, score) -> System.out.println(student + " " + score));

    }
}
