package static_methods;

public class Test implements MyFuncInterface {

    public static void main(String[] args) {
        String input = "";
        boolean result = MyFuncInterface.isNullOrEmpty(input);
        System.out.println(result);
    }

}
