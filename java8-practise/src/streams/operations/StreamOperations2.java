package streams.operations;

import streams.model.Employee;
import streams.util.StreamsUtil;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations2 {
    public static void main(String[] args) {
        //iterate();
        next();

        allGroupBy();

        /*filter();
        next();

        map();
        next();

        flatMap();
        next();

        groupingBy();
        next();

        sortList();
        next();

        groupingByAndSortAsc();
        next();

        groupingByAndSortDesc();
        next();

        groupingByAndFilterAndSort();
        next();

        findSumInteger();
        next();*/
    }

    private static void allGroupBy() {
        List<Employee> employees = StreamsUtil.getEmployees();
        employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCity().getName(),
                        TreeMap::new, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " " + value));
        next();
        employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCity().getName(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldv, newv) -> oldv, LinkedHashMap::new))
                .forEach((city, count) -> System.out.println(city + " " + count));


    }

    private static void findSumInteger() {
        int sum = StreamsUtil.getEmployees()
                .stream()
                //.map(employee -> employee.getId())
                .mapToInt(Employee::getId)
                .sum();
        System.out.println("sum = " + sum);

        double salSum = StreamsUtil.getEmployees()
                .stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("salSum = " + salSum);


    }

    private static void groupingByAndFilterAndSort() {
        LinkedHashMap<String, Long> collect = StreamsUtil.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity().getName(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 4)
                .sorted(Map.Entry.comparingByValue())
                // .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldV, newV) -> oldV, LinkedHashMap::new));

        System.out.println("collect = " + collect);


    }

    private static void groupingByAndSortDesc() {
        Map<String, Long> cityWiseASC = StreamsUtil.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity().getName(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new));
        cityWiseASC.forEach((city, count) -> System.out.println("city = " + city + ", count: " + count));

        LinkedHashMap<String, Long> cityWisDesc = StreamsUtil.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity().getName(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new));
        cityWisDesc.forEach((city, count) -> System.out.println("city = " + city + ", count: " + count));


    }

    private static void groupingByAndSortAsc() {
        //Basic
        Map<String, List<Employee>> cityWise = StreamsUtil.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity().getName()));
        cityWise.forEach((city, count) -> System.out.println("city = " + city + ", count: " + count.size()));

        /*
        TreeMap<String, List<Employee>> cityWiseASC = StreamsUtil.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity().getName(),
                        TreeMap::new, Collectors.toList()));
        cityWiseASC.forEach((city,count) -> System.out.println("city = " + city +", count: "+count.size()));

        TreeMap<String, List<Employee>> cityWiseDesc = StreamsUtil.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity().getName(),
                        () -> new TreeMap<String, List<Employee>>(Comparator.reverseOrder()),
                        Collectors.toList()));

        cityWiseDesc.forEach((city,count) -> System.out.println("city = " + city +", count: "+count.size()));*/

        TreeMap<String, Long> cityWiseASC = StreamsUtil.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity().getName(),
                        TreeMap::new, Collectors.counting()));
        cityWiseASC.forEach((city, count) -> System.out.println("city = " + city + ", count: " + count));

        TreeMap<String, Long> cityWiseDesc = StreamsUtil.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity().getName(),
                        () -> new TreeMap<String, Long>(Comparator.reverseOrder()),
                        Collectors.counting()));

        cityWiseDesc.forEach((city, count) -> System.out.println("city = " + city + ", count: " + count));


    }

    private static void sortList() {
        StreamsUtil.getEmployees()
                .stream()
                .sorted(Comparator.comparing(Employee::getName))
                //.sorted(Comparator.comparing(Employee :: getName, Comparator.reverseOrder()))
                .forEach(emp -> System.out.println(emp.getName()));
    }

    private static void iterate() {
        List<Employee> employees = StreamsUtil.getEmployees();
        employees.forEach(employee -> System.out.println(employee));
    }

    private static void filter() {
        List<Employee> employees = StreamsUtil.getEmployees();
        employees.stream().filter(employee -> "Pune".equals(employee.getCity().getName()))
                .forEach(System.out::println);
    }

    private static void map() {
        StreamsUtil.getEmployees()
                .stream()
                .map(employee -> employee.getCity())
                .collect(Collectors.toList())
                .forEach(city -> System.out.println("city = " + city));
    }

    private static void flatMap() {
        StreamsUtil.getEmployees()
                .stream()
                //.map(emp -> emp.getRoles()) //returns Stream<List<Role>>
                .flatMap(employee -> employee.getRoles().stream()) //Stream<Role> i.e. flattened version
                .collect(Collectors.toList())
                .forEach(role -> System.out.println("role = " + role));
    }

    private static void groupingBy() {
        List<Employee> employees = StreamsUtil.getEmployees();
        Map<String, Long> empByGenderCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("collect = " + empByGenderCount);
    }

    private static void next() {
        System.out.println("================================================================================================================================================");
    }


}
