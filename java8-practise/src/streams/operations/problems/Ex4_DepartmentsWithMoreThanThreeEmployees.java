package streams.operations.problems;

import streams.model.Employee;
import streams.util.StreamsUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex4_DepartmentsWithMoreThanThreeEmployees {
    public static void main(String[] args) {
        List<Employee> employees = StreamsUtil.getEmployees();
        List<String> deptWithMoreThan = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 6)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(deptWithMoreThan);
        ;
    }

}
