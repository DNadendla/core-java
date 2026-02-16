package practise;

import streams.model.Employee;
import streams.util.StreamsUtil;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Employee> employees = StreamsUtil.getEmployees();
        Map<String, List<Employee>> empByCity = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getCity().getName()));
        empByCity.forEach((city, empList) -> {
            System.out.println("City: " + city + ", Employees: "+ empList.size());
        });
        empByCity.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                     Map.Entry::getKey, Map.Entry::getValue,
                        (existing, duplicate) -> existing, LinkedHashMap :: new
                ))
                .forEach((city, empList) -> {
                    System.out.println(city);
                });

        employees.stream()
                .sorted(Comparator.comparing(Employee ::getName, Comparator.reverseOrder()))
                .forEach( emp -> System.out.println(emp.getName()));
    }
}
