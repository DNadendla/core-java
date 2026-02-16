package streams.operations.problems;

import streams.model.Employee;
import streams.util.StreamsUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex1_DepartmentWiseEmpCount {
    public static void main(String[] ags) {
        /*List<Employee> employees = StreamsUtil.getEmployees();
        Map<String, Long> empCountByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        empCountByDept.forEach((dept, count) -> System.out.println(dept + " - " + count));*/
    	
    	List<Employee> employees = StreamsUtil.getEmployees();
    	Map<String, Long> empByDept = employees.stream()
    	.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
    	.entrySet()
    	.stream()
    	.filter(entry -> entry.getValue() >= 6)
    	.collect(Collectors.toMap(
    			Map.Entry::getKey,
    			Map.Entry::getValue));
    	empByDept.entrySet()
    	.forEach(entry -> System.out.println(entry));
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

