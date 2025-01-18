package streams.operations;

import streams.model.Employee;
import streams.model.Role;
import streams.util.StreamsUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {
        iterate();
        System.out.println("================================================================================================================================================");

        filter();
        System.out.println("================================================================================================================================================");

        map();
        System.out.println("================================================================================================================================================");

        flatMap();
        System.out.println("================================================================================================================================================");

        groupingBy();
        System.out.println("================================================================================================================================================");

        ParitionBy();
        System.out.println("================================================================================================================================================");

        filterAndGroupingBy();

    }

    private static void filterAndGroupingBy() {
        List<Employee> employees = StreamsUtil.getEmployees();
        Map<String, List<Employee>> empLT30ByCity = employees.stream().filter(employee -> employee.getAge() < 30)
                .collect(Collectors.groupingBy(employee -> employee.getCity().getName()));
        empLT30ByCity.forEach((city, empLT30City) -> {
            System.out.println(city +" - "+ empLT30City.size());
        });
    }

    private static void ParitionBy() {
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
            System.out.println("City Code: "+ cityCode + ", Emp Count: "+ employeesInCity.size());
        });
    }

    private static void flatMap() {
        List<Employee> employees = StreamsUtil.getEmployees();
        Set<String> roleCodes = employees.stream().map(employee -> employee.getRoles())
                .flatMap(role -> role.stream())
                .map(roleCode -> roleCode.getCode())
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
}
