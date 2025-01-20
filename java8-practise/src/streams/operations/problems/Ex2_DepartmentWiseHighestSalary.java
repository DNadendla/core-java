package streams.operations.problems;

import streams.model.Employee;
import streams.util.StreamsUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ex2_DepartmentWiseHighestSalary {
    public static void main(String[] args) {
        List<Employee> employees = StreamsUtil.getEmployees();
        Map<String, Optional<Employee>> deptWiseHigSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                ));
        deptWiseHigSalary.forEach((dept, employee) -> System.out.println(dept + " " + employee.get().getName() + " " + employee.get().getSalary()));

        System.out.println("----");

        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                .forEach(employee -> System.out.println(employee.getDepartment() + " " + employee.getName()
                        + " " + employee.getSalary()));

    }
}



