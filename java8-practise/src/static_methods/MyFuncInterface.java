package static_methods;

public interface MyFuncInterface {
    static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
