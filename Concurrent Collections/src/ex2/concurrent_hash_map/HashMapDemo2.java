package ex2.concurrent_hash_map;

import java.util.HashMap;

public class HashMapDemo2 extends Thread {

    static HashMap<Integer, String> concurrentHashMap = new HashMap<>();

    @Override
    public void run() {
        sleep(200);
        concurrentHashMap.put(4, "Mahesh");
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        concurrentHashMap.put(1, "sai");
        concurrentHashMap.put(2, "Ram");
        concurrentHashMap.put(3, "Kumar");

        //starting child thread
        HashMapDemo2 concurrentHashMapDemo2 = new HashMapDemo2();
        concurrentHashMapDemo2.start();

        concurrentHashMap.forEach((key, value) -> {
            sleep(300);
            System.out.println("key = " + key + ", value = " + value);
        });
    }
}
