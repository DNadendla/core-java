package streams.operations.problems;

import streams.model.Employee;
import streams.util.StreamsUtil;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex3_DepartmentWithMostEmployees {
    public static void main(String[] args) {
        approach1();
        approach2();
    }

    private static void approach2() {
        List<Employee> employees = StreamsUtil.getEmployees();
        Map<String, Long> empByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        Map.Entry<String, Long> deptWithMostEmps = empByDept.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
        System.out.println(deptWithMostEmps.getKey() + " " + deptWithMostEmps.getValue());
    }

    private static void approach1() {
        List<Employee> employees = StreamsUtil.getEmployees();
        Map<String, Long> empCountByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()));
        LinkedHashMap<String, Long> sortedData = empCountByDept.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (obj1, obj2) -> obj1, LinkedHashMap::new
                ));

        String key = sortedData.entrySet().stream().findFirst().get().getKey();
        Long value = sortedData.entrySet().stream().findFirst().get().getValue();
        System.out.println(key + " " +value);
    }
}
