package ex1.blocking_demo;

public class BlockingExample {
    public static void main(String[] args) {
        System.out.println("Start");
        try {
            // Simulate a blocking operation
            Thread.sleep(2000); // Thread is blocked for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }
}
