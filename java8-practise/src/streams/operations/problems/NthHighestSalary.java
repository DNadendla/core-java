package streams.operations.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class NthHighestSalary {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 50000),
                new Employee("Jane", 60000),
                new Employee("Alex", 70000),
                new Employee("Emma", 80000),
                new Employee("Doe", 90000),
                new Employee("Smith", 80000), // Same salary as Emma
                new Employee("Chris", 70000)  // Same salary as Alex
        );

        int n = 3; // Change this to find other N-th highest salaries

        List<Double> salaries = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(salaries);

        if (n <= salaries.size()) {
            Double nthHighest = salaries.get(n - 1);
            List<Employee> nthHighestEmployees = employees.stream()
                    .filter(employee -> employee.getSalary() == nthHighest)
                    .collect(Collectors.toList());
            System.out.println(nthHighestEmployees);
        } else {
            System.out.println("Invalid Range: " + n);
        }

    }
}
