package streams.operations.problems;

import streams.model.Employee;
import streams.util.StreamsUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex1_DepartmentWiseEmpCount {
    public static void main(String[] args) {
        List<Employee> employees = StreamsUtil.getEmployees();
        Map<String, Long> empCountByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        empCountByDept.forEach((dept, count) -> System.out.println(dept + " - " + count));
    }
}

/**
 * with Sorting
 * Map<String, Long> empCountByDept = employees.stream()
 *                 .collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.counting()))
 *                 .entrySet()
 *                 .stream()
 *                 .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
 *                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
 *                         (oldV, newV) -> oldV, LinkedHashMap :: new));
 *
 */

