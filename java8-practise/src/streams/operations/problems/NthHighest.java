package streams.operations.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NthHighest {
	public static void main(String[] args) {
		//approach1();
		approach2();
	}

	private static void approach1() {
		List<Integer> data = Arrays.asList(1,2,3,4,5,5);
		Integer integer = data.stream()
				.distinct()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.get();
		System.out.println(integer);
		

	}

	private static void approach2() {
		List<Employee> employees = Arrays.asList(
                new Employee("John", 50000.0),
                new Employee("Jane", 60000.0),
                new Employee("Alex", 70000.0),
                new Employee("Emma", 80000.0),
                new Employee("Doe", 90000.0),
                new Employee("Smith", 80000.0), // Same salary as Emma
                new Employee("Chris", 70000.0)  // Same salary as Alex
        );

        int n = 5;
        
        //find distinct salaries in desc sorted order
        List<Double> salaries = employees.stream()
        		.map(employee -> employee.getSalary())
        		.distinct()
        		.sorted(Comparator.reverseOrder())
        		.collect(Collectors.toList());
        System.out.println(salaries);
        
        if(n <= salaries.size()) {
        	Double nthHighest = salaries.get(n-1);
        	List<Employee> nthHighestEmps = employees.stream()
        	.filter(emp -> emp.getSalary() == nthHighest)
        	.collect(Collectors.toList());
        	System.out.println(nthHighestEmps);
        } else {
        	System.out.println("invalid range!!");
        }
        
		
	}

}
