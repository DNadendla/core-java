package streams.operations.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxAndMinFromMap {

	public static void main(String[] args) {
		Map<String, Integer> studentMarks = new HashMap<>();
        studentMarks.put("Datta", 100);
        studentMarks.put("Sai", 92);
        studentMarks.put("Prasanth", 99);
        studentMarks.put("Jitendra", 95);
        studentMarks.put("Ravi", 88);
        
        LinkedHashMap<String, Integer> sortedMap = studentMarks.entrySet()
        			.stream()
        			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        			.collect(Collectors.toMap(
        					Map.Entry::getKey, 
        					Map.Entry::getValue,
        					(obj1, obj2) -> obj1,
        					LinkedHashMap :: new
        					));
        
        sortedMap.entrySet()
        .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        
        System.out.println("----");
        
        Optional<Entry<String,Integer>> max = 
        		studentMarks.entrySet()
					        .stream()
					        .max(Map.Entry.comparingByValue());
        System.out.println("Max: "+max.get());
	}
	
}
