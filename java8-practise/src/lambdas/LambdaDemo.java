package lambdas;

import java.util.Map;

public class LambdaDemo {

    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface = (name, msg) -> {
            return name+ " "+ msg +" !!!!";
        };
        String hello = myFunctionalInterface.wish("Dattasai","Hello");
        System.out.println(hello);
    }
}
