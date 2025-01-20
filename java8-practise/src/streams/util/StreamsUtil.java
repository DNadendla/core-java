package streams.util;

import streams.model.City;
import streams.model.Country;
import streams.model.Employee;
import streams.model.Role;
import streams.model.State;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StreamsUtil {

    public static Date parseDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            System.out.println("Invalid date, reason: " + e.getMessage());
            return null;
        }
    }
    
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
        employees.add(new Employee(1, "Alice", "IT", 30, mumbai, "Female", Arrays.asList(developer, tester), parseDate("2020-01-15"), parseDate("1990-05-10"), 75000.0));
        employees.add(new Employee(2, "Bob","IT", 25, pune, "Male", new ArrayList<>(), parseDate("2021-03-12"), parseDate("1995-09-18"), 50000.0));
        employees.add(new Employee(3, "Charlie", "IT",28, bangalore, "Male", Arrays.asList(manager), parseDate("2018-06-01"), parseDate("1992-11-22"), 90000.0));
        employees.add(new Employee(4, "Diana", "IT",32, losAngeles, "Female", new ArrayList<>(), parseDate("2017-02-14"), parseDate("1988-03-05"), 85000.0));
        employees.add(new Employee(5, "Eve", "IT",29, mumbai, "Female", new ArrayList<>(), parseDate("2020-07-19"), parseDate("1991-12-25"), 72000.0));
        employees.add(new Employee(6, "Frank", "FINANCE",27, pune, "Male", new ArrayList<>(), parseDate("2019-11-05"), parseDate("1993-04-11"), 60000.0));
        employees.add(new Employee(7, "Grace", "FINANCE",35, bangalore, "Female", Arrays.asList(developer), parseDate("2016-08-30"), parseDate("1985-06-15"), 95000.0));
        employees.add(new Employee(8, "Hank", "FINANCE",31, losAngeles, "Male", new ArrayList<>(), parseDate("2018-12-22"), parseDate("1989-07-03"), 87000.0));
        employees.add(new Employee(9, "Ivy", "FINANCE",26, mumbai, "Female", new ArrayList<>(), parseDate("2022-01-10"), parseDate("1996-10-17"), 55000.0));
        employees.add(new Employee(10, "Jack", "FINANCE",33, pune, "Male", Arrays.asList(tester), parseDate("2015-05-25"), parseDate("1987-08-29"), 80000.0));
        employees.add(new Employee(11, "Kim", "FINANCE",24, bangalore, "Female", new ArrayList<>(), parseDate("2021-09-11"), parseDate("1997-02-08"), 48000.0));
        employees.add(new Employee(12, "Leo", "HR",30, losAngeles, "Male", new ArrayList<>(), parseDate("2019-04-18"), parseDate("1990-09-14"), 78000.0));
        employees.add(new Employee(13, "Mona", "HR",28, mumbai, "Female", new ArrayList<>(), parseDate("2020-10-20"), parseDate("1992-03-21"), 65000.0));
        employees.add(new Employee(14, "Nate", "HR",29, pune, "Male", new ArrayList<>(), parseDate("2017-01-30"), parseDate("1991-12-03"), 67000.0));
        employees.add(new Employee(15, "Olivia", "IT",27, bangalore, "Female", new ArrayList<>(), parseDate("2020-06-16"), parseDate("1993-11-09"), 61000.0));
        employees.add(new Employee(16, "Paul", "IT",34, losAngeles, "Male", Arrays.asList(manager), parseDate("2014-03-08"), parseDate("1986-05-25"), 98000.0));
        employees.add(new Employee(17, "Quinn", "IT",30, mumbai, "Female", new ArrayList<>(), parseDate("2020-08-12"), parseDate("1990-07-07"), 70000.0));
        employees.add(new Employee(18, "Rita", "IT",26, pune, "Female", new ArrayList<>(), parseDate("2022-05-01"), parseDate("1996-10-11"), 52000.0));
        employees.add(new Employee(19, "Steve", "HR",32, bangalore, "Male", new ArrayList<>(), parseDate("2018-04-09"), parseDate("1988-06-22"), 86000.0));
        employees.add(new Employee(20, "Tracy", "HR",29, losAngeles, "Female", Arrays.asList(developer, tester), parseDate("2020-02-18"), parseDate("1991-08-15"), 75000.0));

        return employees;
    }
}
