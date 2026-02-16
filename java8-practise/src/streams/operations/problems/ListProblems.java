package streams.operations.problems;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.sound.midi.Soundbank;

public class ListProblems {
	/*public static void main(String[] args) {
		List<String> list = List.of("Apple", "Apple", "Banana", "Orange", "Chilli");
		List<String> ascList = list.stream()
		.sorted()
		.collect(Collectors.toList());
		ascList.forEach(item -> System.out.println(item));
		
		System.out.println("==================================================================");
		
		List<String> dscList = list.stream()
		.sorted(Comparator.reverseOrder())
		.collect(Collectors.toList());
		dscList.forEach(item -> System.out.println(item));
		
		System.out.println("==================================================================");
		
		*//**
		 * Group by item
		 *//*
		Map<String,List<String>> collect = list.stream()
		.collect(Collectors.groupingBy(Function.identity()));
		
		collect.entrySet().forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue().size()));
		
		System.out.println("==================================================================");
		
		Map<String, Long> itemByCount = list.stream()
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		LinkedHashMap<String, Long> itemByCountAsc = itemByCount.entrySet()
					.stream()
					.sorted(Map.Entry.comparingByKey())
					.collect(Collectors.toMap(
							Map.Entry::getKey,
							Map.Entry::getValue,
							(obj1, obj2) -> obj1,
							LinkedHashMap :: new
							));
		
		
		  itemByCountAsc.entrySet() .forEach(entry -> System.out.println(entry));
		 
		  System.out.println("==================================================================");
		  
		LinkedHashMap<String, Long> itemByCountDesc = itemByCount.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
		.collect(Collectors.toMap(
				Map.Entry::getKey,
				Map.Entry::getValue,
				(obj1, obj2) -> obj1,
				LinkedHashMap :: new
				));
		
		itemByCountDesc.entrySet()
		.forEach(entry -> System.out.println(entry));
		
		System.out.println("==================================================================");
		
		*//**
		 * Group By Length
		 *//*
		Map<Integer, List<String>> itemsGroupedByLength = list.stream()
		.collect(Collectors.groupingBy(String :: length));
		
		itemsGroupedByLength.entrySet()
		.forEach(entry -> System.out.println(entry));

		
	}*/
}
