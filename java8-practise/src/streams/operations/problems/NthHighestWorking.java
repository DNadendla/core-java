package streams.operations.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NthHighestWorking {

    public static void main(String[] args) {
        List<Employee> employees = getEmpData();
        Optional<Double> nthHighestSalary = getNthHighestSalary(employees,2);
        nthHighestSalary.ifPresent(System.out::println);
    }

    public static Optional<Double> getNthHighestSalary(List<Employee> employees, int n) {
        /*return employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(n - 1)
                .findFirst();*/

        return employees.stream()
                .map(Employee :: getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(n-1)
                .findFirst();
    }

    private static List<Employee> getEmpData() {
        return Arrays.asList(
                new Employee("John", 50000.0),
                new Employee("Jane", 60000.0),
                new Employee("Alex", 70000.0),
                new Employee("Emma", 80000.0),
                new Employee("Doe", 90000.0),
                new Employee("Smith", 80000.0), // Same salary as Emma
                new Employee("Chris", 70000.0)  // Same salary as Alex
        );
    }
}
