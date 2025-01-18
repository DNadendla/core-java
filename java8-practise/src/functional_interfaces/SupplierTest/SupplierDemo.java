package functional_interfaces.SupplierTest;

import java.security.PrivilegedAction;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            return "Welcome Message";
        };
        System.out.println(supplier.get());

//        Supplier<Long> currentTimeSupplier = () -> System.currentTimeMillis();
        Supplier<Long> currentTimeSupplier = System::currentTimeMillis;
        System.out.println(currentTimeSupplier.get()); // Output: [Current Time in Milliseconds]

    }
}
