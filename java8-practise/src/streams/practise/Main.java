package streams.practise;

import streams.model.Employee;
import streams.util.StreamsUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(4, 4, 4, 4);
        Integer sum = data.stream()
                //.reduce(0, Integer::sum);
                .mapToInt(num -> num)
                .sum();

        OptionalDouble average = data.stream()
                                .mapToInt(num -> num)
                                .average();
        System.out.println(sum + " " + average.getAsDouble());

        List<Employee> employees = StreamsUtil.getEmployees();
        employees.stream().sorted(Comparator.comparing(Employee :: getDateOfBirth));
//                .forEach(emp -> System.out.println(emp.getDateOfBirth()));

        employees.stream().sorted(Comparator.comparing(Employee :: getDateOfBirth, Comparator.reverseOrder()));
//                .forEach(emp -> System.out.println(emp.getDateOfBirth()));

        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(emp -> emp.getCity().getCode()));

        collect.forEach((city, emp) -> {
            System.out.println("city - " + city + " size - "+ emp.size());
        });

        LinkedHashMap<String, List<Employee>> sortedMap = collect.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));
        sortedMap.forEach((city, emp) -> System.out.println("city - " + city + " size - "+ emp.size()));

    }


}
