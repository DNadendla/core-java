package streams.practise;

import streams.model.City;
import streams.model.Employee;
import streams.util.StreamsUtil;

import java.util.*;
import java.util.stream.Collectors;

public class OperationsPractise {
    public static void main(String[] args) {
        /*sortIntegers();
        sortStringBuilders();
        sortMap();*/

        sortCustomObj();
        sortCustomMapObj();


    }

    private static void sortCustomMapObj() {
        List<Employee> employees = StreamsUtil.getEmployees();
        /*Map<String, List<Employee>> groupByCity = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity().getName()));
        LinkedHashMap<String, List<Employee>> sortedByCity = groupByCity.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (existing, duplicate) -> existing,
                        LinkedHashMap::new
                ));
        sortedByCity.forEach((city, emps) -> System.out.println(city + " " + emps.size()));*/

        Map<City, List<Employee>> groupByCity = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity()));
        LinkedHashMap<City, List<Employee>> sortedByCity = groupByCity.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(City::getName)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (existing, duplicate) -> existing,
                        LinkedHashMap::new
                ));
        sortedByCity.forEach((city, emps) -> System.out.println(city.getName() + " " + emps.size()));

    }

    private static void sortCustomObj() {
        List<Employee> employees = StreamsUtil.getEmployees();
        employees.stream()
                .sorted(Comparator.comparing(employee -> employee.getName()))
//                .sorted(Comparator.comparing(employee -> employee.getName().length()))
                .forEach(emp -> System.out.println(emp.getName()));
        System.out.println("---------");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName, Comparator.reverseOrder()))
                .forEach(emp -> System.out.println(emp.getName()));
//                .collect(Collectors.toList());
    }

    private static void sortMap() {
        Map<Integer, String> mapData = new HashMap<>();
        mapData.put(101, "Apple");
        mapData.put(102, "Banana");
        mapData.put(103, "Cherry");
        mapData.put(104, "Date");
        mapData.put(105, "Elderberry");

        LinkedHashMap<Integer, String> sortedByKey = mapData.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (existing, duplicate) -> existing,
                        LinkedHashMap::new
                ));
        sortedByKey.forEach((id, name) -> System.out.println(id + " " + name));

        LinkedHashMap<Integer, String> sortedByDesc = mapData.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (existing, duplicate) -> existing,
                        LinkedHashMap::new
                ));
        sortedByDesc.forEach((id, name) -> System.out.println(id + " " + name));
    }

    private static void sortStringBuilders() {
        List<StringBuilder> list = Arrays.asList(
                new StringBuilder("banana"),
                new StringBuilder("apple"),
                new StringBuilder("cherry")
        );
        /**
         * To-Do - Issue fix
         */
        /*List<StringBuilder> sortedList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList);*/
    }

    private static void sortIntegers() {
        List<Integer> list = Arrays.asList(10, 2, 3);
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        List<Integer> sortedListDesc = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedListDesc);
    }
}
