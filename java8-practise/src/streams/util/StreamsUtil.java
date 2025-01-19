package streams.util;

import streams.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsUtil {

    public static List<Employee> getEmployees() {
        // Create countries
        Country india = new Country(1, "India", "IN");
        Country usa = new Country(2, "United States", "US");

        // Create states
        State maharashtra = new State(1, "Maharashtra", "MH", india);
        State karnataka = new State(2, "Karnataka", "KA", india);
        State california = new State(3, "California", "CA", usa);

        // Create cities
        City mumbai = new City(1, "Mumbai", "MUM", maharashtra);
        City pune = new City(2, "Pune", "PUN", maharashtra);
        City bangalore = new City(3, "Bangalore", "BLR", karnataka);
        City losAngeles = new City(4, "Los Angeles", "LA", california);

        // Create roles
        Role developer = new Role("Developer", "DEV");
        Role tester = new Role("Tester", "TST");
        Role manager = new Role("Manager", "MGR");

        // Create employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", 30, pune, "Female", Arrays.asList(developer, tester)));
        employees.add(new Employee(2, "Bob", 25, pune, "Male"));
        employees.add(new Employee(3, "Charlie", 28, bangalore, "Male", Arrays.asList(manager)));
        employees.add(new Employee(4, "Diana", 32, losAngeles, "Female"));
        employees.add(new Employee(5, "Eve", 29, mumbai, "Female"));
        employees.add(new Employee(6, "Frank", 27, pune, "Male"));
        employees.add(new Employee(7, "Grace", 35, bangalore, "Female", Arrays.asList(developer)));
        employees.add(new Employee(8, "Hank", 31, losAngeles, "Male"));
        employees.add(new Employee(9, "Ivy", 26, mumbai, "Female"));
        employees.add(new Employee(10, "Jack", 33, pune, "Male", Arrays.asList(tester)));
        employees.add(new Employee(11, "Kim", 24, bangalore, "Female"));
        employees.add(new Employee(12, "Leo", 30, losAngeles, "Male"));
        employees.add(new Employee(13, "Mona", 28, mumbai, "Female"));
        employees.add(new Employee(14, "Nate", 29, pune, "Male"));
        employees.add(new Employee(15, "Olivia", 27, bangalore, "Female"));
        employees.add(new Employee(16, "Paul", 34, losAngeles, "Male", Arrays.asList(manager)));
        employees.add(new Employee(17, "Quinn", 30, mumbai, "Female"));
        employees.add(new Employee(18, "Rita", 26, pune, "Female"));
        employees.add(new Employee(19, "Steve", 32, bangalore, "Male"));
        employees.add(new Employee(20, "Tracy", 29, losAngeles, "Female", Arrays.asList(developer, tester)));

        return employees;
    }
}
