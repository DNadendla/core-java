package streams.util;

import streams.model.City;
import streams.model.Country;
import streams.model.Employee;
import streams.model.Role;
import streams.model.State;

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
        // Create employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", 30, mumbai, "Female", Arrays.asList(developer, tester), Employee.parseDate("2020-01-15"), Employee.parseDate("1990-05-10")));
        employees.add(new Employee(2, "Bob", 25, pune, "Male", new ArrayList<>(), Employee.parseDate("2021-03-12"), Employee.parseDate("1995-09-18")));
        employees.add(new Employee(3, "Charlie", 28, bangalore, "Male", Arrays.asList(manager), Employee.parseDate("2018-06-01"), Employee.parseDate("1992-11-22")));
        employees.add(new Employee(4, "Diana", 32, losAngeles, "Female", new ArrayList<>(), Employee.parseDate("2017-02-14"), Employee.parseDate("1988-03-05")));
        employees.add(new Employee(5, "Eve", 29, mumbai, "Female", new ArrayList<>(), Employee.parseDate("2020-07-19"), Employee.parseDate("1991-12-25")));
        employees.add(new Employee(6, "Frank", 27, pune, "Male", new ArrayList<>(), Employee.parseDate("2019-11-05"), Employee.parseDate("1993-04-11")));
        employees.add(new Employee(7, "Grace", 35, bangalore, "Female", Arrays.asList(developer), Employee.parseDate("2016-08-30"), Employee.parseDate("1985-06-15")));
        employees.add(new Employee(8, "Hank", 31, losAngeles, "Male", new ArrayList<>(), Employee.parseDate("2018-12-22"), Employee.parseDate("1989-07-03")));
        employees.add(new Employee(9, "Ivy", 26, mumbai, "Female", new ArrayList<>(), Employee.parseDate("2022-01-10"), Employee.parseDate("1996-10-17")));
        employees.add(new Employee(10, "Jack", 33, pune, "Male", Arrays.asList(tester), Employee.parseDate("2015-05-25"), Employee.parseDate("1987-08-29")));
        employees.add(new Employee(11, "Kim", 24, bangalore, "Female", new ArrayList<>(), Employee.parseDate("2021-09-11"), Employee.parseDate("1997-02-08")));
        employees.add(new Employee(12, "Leo", 30, losAngeles, "Male", new ArrayList<>(), Employee.parseDate("2019-04-18"), Employee.parseDate("1990-09-14")));
        employees.add(new Employee(13, "Mona", 28, mumbai, "Female", new ArrayList<>(), Employee.parseDate("2020-10-20"), Employee.parseDate("1992-03-21")));
        employees.add(new Employee(14, "Nate", 29, pune, "Male", new ArrayList<>(), Employee.parseDate("2017-01-30"), Employee.parseDate("1991-12-03")));
        employees.add(new Employee(15, "Olivia", 27, bangalore, "Female", new ArrayList<>(), Employee.parseDate("2020-06-16"), Employee.parseDate("1993-11-09")));
        employees.add(new Employee(16, "Paul", 34, losAngeles, "Male", Arrays.asList(manager), Employee.parseDate("2014-03-08"), Employee.parseDate("1986-05-25")));
        employees.add(new Employee(17, "Quinn", 30, mumbai, "Female", new ArrayList<>(), Employee.parseDate("2020-08-12"), Employee.parseDate("1990-07-07")));
        employees.add(new Employee(18, "Rita", 26, pune, "Female", new ArrayList<>(), Employee.parseDate("2022-05-01"), Employee.parseDate("1996-10-11")));
        employees.add(new Employee(19, "Steve", 32, bangalore, "Male", new ArrayList<>(), Employee.parseDate("2018-04-09"), Employee.parseDate("1988-06-22")));
        employees.add(new Employee(20, "Tracy", 29, losAngeles, "Female", Arrays.asList(developer, tester), Employee.parseDate("2020-02-18"), Employee.parseDate("1991-08-15")));

        return employees;
    }
}
