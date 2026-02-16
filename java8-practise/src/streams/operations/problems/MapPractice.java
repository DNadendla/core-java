package streams.operations.problems;

import streams.model.City;
import streams.model.Employee;
import streams.util.StreamsUtil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapPractice {
    public static void main(String[] args) {
        List<Employee> employees = StreamsUtil.getEmployees();
        Map<City, Long> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(City::getName, Comparator.reverseOrder())))
//                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (existing, duplicate) -> existing, LinkedHashMap::new
                ))
                .forEach((city, count) -> System.out.println("city = " + city.getName() + ", count: " + count));

        List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        Map<String, Long> collect = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("collect = " + collect);

//        Third non repeating characters
        String input = "FeDKFAbbA";
        /*steam, group by elmnt, value==1, skip till 2
         * */
        Optional<Map.Entry<String, Long>> nonRep3 = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .skip(2)
                .findFirst();
        if (nonRep3.isPresent())
            System.out.println("nonRep3 = " + nonRep3.get().getKey());

        String str = "Java Name";
        String reverStr = Arrays.stream(str.split(" "))
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println("reverStr = " + reverStr);

        List<Integer> numbers = Arrays.asList(10, 20, 30);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum = " + sum);

        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue)
//                .mapToInt(num -> num)
                .average();
        System.out.println("average = " + average.getAsDouble());

        OptionalInt min = numbers.stream()
                .mapToInt(Integer::intValue)
                .min();
        System.out.println("min = " + min.getAsInt());

        double empSalaries = employees.stream()
                //.map(Employee::getSalary)
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("empSalaries = " + empSalaries);

        OptionalDouble empSalAvg = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average();
        System.out.println("empSalAvg = " + empSalAvg.getAsDouble());
    }
}
