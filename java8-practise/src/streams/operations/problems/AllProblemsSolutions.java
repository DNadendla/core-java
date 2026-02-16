package streams.operations.problems;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import streams.model.Employee;
import streams.util.StreamsUtil;

public class AllProblemsSolutions {

	public static void main(String[] args) {
		List<Employee> employees = StreamsUtil.getEmployees();
		
		Map<String,Long> empCountByDept = employees.stream()
		.collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.counting()));
		empCountByDept.entrySet()
						.stream()
						.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
						.collect(Collectors.toMap(
								Map.Entry::getKey,
								Map.Entry::getValue,
								(obj1, obj2) -> obj1,
								LinkedHashMap :: new
								));
		
		//departmentWiseEmployeeCount(employees);
		
		//departmentWiseHighestSalary(employees);
		
		//departmentWithMostNumberOfEmployees(employees);
		
		//departmentWiseMoreThan5Employees(employees);
		
		//nthHighestSalariedEmployee(employees, 1);

	}

	private static void nthHighestSalariedEmployee(List<Employee> employees, int n) {
		
		Optional<Employee> max = employees.stream().max(Comparator.comparing(Employee :: getSalary));
		System.out.println(max.get().getName() + " " + max.get().getSalary());
		//1. get all distinct salaries
			List<Double> salaries = employees.stream()
					.map(emp -> emp.getSalary())
					.distinct()
					.sorted(Comparator.reverseOrder())
					.collect(Collectors.toList());
		
			if(n <= salaries.size()) {
				//2. get the salary based on n
				Double nthHigestSalary = salaries.get(n-1);
				
				
			//3. filter the Employee based on s2
				List<Employee> nthHighestSalariedEmployee = employees
				.stream()
				.filter(emp -> emp.getSalary() == nthHigestSalary)
				.collect(Collectors.toList());
				
				nthHighestSalariedEmployee.forEach(emp -> {
					System.out.println(emp.getName() + " " +emp.getSalary());
				});
				
			} else {
				System.out.println("Specified range based employees not available!");
			}
			
	}

	private static void departmentWiseMoreThan5Employees(List<Employee> employees) {
		employees.stream()
		.collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.counting()))
		.entrySet()
		.stream()
		.filter(entry -> entry.getValue() > 5)
		.forEach(entry -> System.out.println(entry.getKey() + " "+ entry.getValue()));
	}

	private static void departmentWithMostNumberOfEmployees(List<Employee> employees) {
		Optional<Entry<String,Long>> max = 
				employees.stream()
							.collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.counting()))
							.entrySet()
							.stream()
							.max(Map.Entry.comparingByValue());
		//System.out.println(max.get());
		max.ifPresent(highSalried -> System.out.println("Department with most employees: " + highSalried.getKey() + " - " + highSalried.getValue()));
	}

	private static void departmentWiseHighestSalary(List<Employee> employees) {
		Map<String, Optional<Employee>> deptWiseHigSalary =
							employees.stream()
									 .collect(Collectors.groupingBy(
											Employee :: getDepartment,
											Collectors.maxBy(Comparator.comparing(Employee :: getSalary))
											));
		
		deptWiseHigSalary
		.entrySet()
		.forEach(entry -> {
			String dept = entry.getKey();
			Employee highestSalariedEmployee = entry.getValue().get();
			 System.out.println(dept + " " 
					 			+highestSalariedEmployee.getName()
					 			+ " " +
					 			highestSalariedEmployee.getSalary());
		});
	}

	private static void departmentWiseEmployeeCount(List<Employee> employees) {
			Map<String, Long> empByDept = employees.stream()
			.collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.counting()));
			
			empByDept.entrySet()
			.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

	}
}
