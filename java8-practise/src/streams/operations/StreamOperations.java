package streams.operations;

import streams.model.Employee;
import streams.util.StreamsUtil;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {
        iterate();
        next();

        filter();
        next();

        map();
        next();

        flatMap();
        next();

        groupingBy();
        next();

        partitioningBy();
        next();

        filterAndGroupingBy();
        next();

        sortList();
        next();

        sortListDesc();
        next();

        groupingByAndSort();
        next();

        groupingByAndSortDesc();
        next();

        groupingByAndFilterAndSort();
        next();

        sortByDate();
        next();

        sortByDateDesc();
        next();

        findSumInteger();
        next();

        findSumDouble();
    }

    private static void findSumInteger() {
        List<Employee> employees = StreamsUtil.getEmployees();
        Integer sumWay1 = employees.stream()
                .map(Employee::getId)
                .reduce(0, Integer::sum);
        System.out.println(sumWay1);

        int sumWay2 = employees.stream()
                .mapToInt(Employee::getId)
                .sum();
        System.out.println(sumWay2);

        OptionalDouble average = employees.stream()
                .mapToInt(Employee::getId)
                .average();
        System.out.println(average.getAsDouble());
    }

    private static void findSumDouble() {
        List<Employee> employees = StreamsUtil.getEmployees();
        Double sumWay1 = employees.stream()
                .map(Employee::getSalary)
                .reduce((double) 0, Double::sum);
        System.out.println(sumWay1);

        double sumWay2 = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println(sumWay2);

        OptionalDouble average = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average();
        System.out.println(average.getAsDouble());

    }

    private static void sortByDateDesc() {
        List<Employee> employees = StreamsUtil.getEmployees();
        employees.stream()
                .sorted(Comparator.comparing(Employee:: getDateOfBirth, Comparator.reverseOrder()))
                .forEach(employee -> System.out.println(employee.getDateOfBirth()));
    }

    private static void sortByDate() {
        List<Employee> employees = StreamsUtil.getEmployees();
        employees.stream()
                .sorted(Comparator.comparing(Employee::getDateOfBirth))
                .collect(Collectors.toList())
                .forEach(employee -> System.out.println(employee.getDateOfBirth()));
    }

    private static void groupingByAndFilterAndSort() {
        List<Employee> employees = StreamsUtil.getEmployees();
        Map<String, List<Employee>> empsByCity = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCity().getCode()));
        LinkedHashMap<String, List<Employee>> empsByCityFiltered = empsByCity.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 4)
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldV, newV) -> oldV, LinkedHashMap::new));

        empsByCityFiltered.forEach((city, emps) -> System.out.println(city + " - " + emps.size()));
    }

    private static void groupingByAndSortDesc() {
        List<Employee> employees = StreamsUtil.getEmployees();
        LinkedHashMap<Integer, List<Employee>> groupingEmpsByAgeAndSortDesc = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldV, newV) -> oldV, LinkedHashMap::new));

        groupingEmpsByAgeAndSortDesc.forEach((age, emps) -> System.out.println(age + " - " + emps.size()));
    }

    /**
     * keyMapper → Map.Entry::getKey
     * Uses the key (age) from each Map.Entry<Integer, List<Employee>>
     * valueMapper → Map.Entry::getValue
     * Uses the value (List<Employee>) from each Map.Entry<Integer, List<Employee>>
     * mergeFunction → (oldV, newV) -> oldV
     * If there are duplicate keys (not possible in this case), it keeps the existing value (oldV).
     * mapSupplier → LinkedHashMap::new
     * Specifies that we want a LinkedHashMap to maintain insertion order.
     */
    private static void groupingByAndSort() {
        List<Employee> employees = StreamsUtil.getEmployees();
        LinkedHashMap<Integer, List<Employee>> empGroupedByAndSort = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldV, newV) -> oldV, LinkedHashMap::new));

        empGroupedByAndSort.forEach((age, emps) -> System.out.println(age + " - " + emps.size()));
    }

    private static void sortListDesc() {
        List<Employee> employees = StreamsUtil.getEmployees();
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge, Comparator.reverseOrder()))
                .forEach(employee -> System.out.println(employee.getName() + " - " + employee.getAge()));
    }

    private static void sortList() {
        List<Employee> employees = StreamsUtil.getEmployees();
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .collect(Collectors.toList())
                .forEach(employee -> {
                    System.out.println(employee.getAge());
                });
    }

    private static void filterAndGroupingBy() {
        List<Employee> employees = StreamsUtil.getEmployees();
        Map<String, List<Employee>> empLT30ByCity = employees.stream().filter(employee -> employee.getAge() < 30)
                .collect(Collectors.groupingBy(employee -> employee.getCity().getName()));
        empLT30ByCity.forEach((city, empLT30City) -> {
            System.out.println(city + " - " + empLT30City.size());
        });
    }

    private static void partitioningBy() {
        List<Employee> employees = StreamsUtil.getEmployees();
        Map<Boolean, List<Employee>> employeesAgeGT30 = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getAge() >= 30));
        employeesAgeGT30.get(true).forEach(employee -> System.out.println(employee.getAge()));
        System.out.println("----------------");
        employeesAgeGT30.get(false).forEach(employee -> System.out.println(employee.getAge()));
    }

    private static void groupingBy() {
        List<Employee> employees = StreamsUtil.getEmployees();
        Map<String, List<Employee>> employeesByCity = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCity().getCode()));
        employeesByCity.forEach((cityCode, employeesInCity) -> {
            System.out.println("City Code: " + cityCode + ", Emp Count: " + employeesInCity.size());
        });
    }

    private static void flatMap() {
        List<Employee> employees = StreamsUtil.getEmployees();
        Set<String> roleCodes = employees.stream()
                .flatMap(employee -> employee.getRoles().stream())
                .map(role -> role.getCode())
                .collect(Collectors.toSet());
        roleCodes.forEach(System.out::println);
    }

    private static void map() {
        List<Employee> employees = StreamsUtil.getEmployees();
        employees.stream().map(employee -> {
            employee.setGender("Gender :: " + employee.getGender());
            return employee;
        }).collect(Collectors.toList());
        employees.forEach(System.out::println);
    }

    private static void filter() {
        List<Employee> employees = StreamsUtil.getEmployees();
        employees.stream().filter(employee -> employee.getAge() > 30).forEach(employee -> System.out.println(employee));
    }

    private static void iterate() {
        List<Employee> employees = StreamsUtil.getEmployees();
        employees.forEach(employee -> {
            System.out.println(employee);
        });
    }

    private static void next() {
        System.out.println("================================================================================================================================================");
    }

}
