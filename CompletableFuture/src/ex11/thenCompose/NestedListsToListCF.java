package ex11.thenCompose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NestedListsToListCF {

  public static void main(String[] args) {
    List<Integer> evens = Arrays.asList(2, 4, 6);
    List<Integer> odds = Arrays.asList(3, 5, 7);
    List<Integer> primes = Arrays.asList(2, 3, 5);

    List<List<Integer>> listOfListOfNumbers = Arrays.asList(
      evens,
      odds,
      primes
    );

    System.out.println("Before flattening: " + listOfListOfNumbers);

    List<Integer> allDistinctNumbers = listOfListOfNumbers
      .stream()
      .flatMap(numList -> numList.stream())
      .distinct()
      .collect(Collectors.toList());

    System.out.println(
      "After flattening, all distinct numbers: " + allDistinctNumbers
    );
  }
}
