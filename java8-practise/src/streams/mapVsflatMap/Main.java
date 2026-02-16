package streams.mapVsflatMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Create addresses for employees
        Address addr1 = new Address("Hyderabad", "Telangana", "India");
        Address addr2 = new Address("Bangalore", "Karnataka", "India");
        Address addr3 = new Address("Pune", "Maharashtra", "India");
        Address addr4 = new Address("Chennai", "Tamil Nadu", "India");

        // Create list of employees
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Datta Sai", 30, Arrays.asList(addr1, addr2)),
                new Employee(102, "Prasanth N", 28, Arrays.asList(addr3)),
                new Employee(103, "Jitendra Kumar", 32, Arrays.asList(addr2, addr4))
        );

        // Print employee details
        //employees.forEach(System.out::println);
        
        List<String> basicSorted = employees.stream()
									        .flatMap(emp -> emp.getAddresses().stream())
									        .map(address -> address.getCity())
									        .distinct()
									        .sorted(Comparator.reverseOrder())
									        .collect(Collectors.toList());

        basicSorted.forEach(city -> System.out.println(city));
        
        List<Address> objectSort = employees.stream()
									        .flatMap(emp -> emp.getAddresses().stream())
									        .distinct()
									        .sorted(Comparator.comparing(Address :: getCity, Comparator.reverseOrder()))
									        .collect(Collectors.toList());
        
        objectSort.forEach(obj -> System.out.println(obj));
        
    }
}
