package ex2.concurrent_hash_map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "sai");
        map.put(2, "ram");
        map.put(3, "mahesh");
        map.put(4, "kumar");

        //putIfAbsent
        System.out.println("putIfAbsent");
        map.putIfAbsent(4, "datt"); // no insertion
        System.out.println(map);
        map.putIfAbsent(5, "kiran");// insertion
        System.out.println(map);

        //remove
        System.out.println("remove");
        map.remove(5, "rajesh"); //no matching entry
        System.out.println(map);
        map.remove(5, "kiran"); // matching entry
        System.out.println(map);

        //replace
        System.out.println("replace");
        map.replace(4, "rxzc","upd_val");
        System.out.println(map); //no changes
        map.replace(4, "kumar", "datta");
        System.out.println(map); //values replaced

    }
}
