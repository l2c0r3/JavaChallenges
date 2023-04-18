package net.c0r3.javachallanges.math;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Ex05_PrimePairs {

  private Ex05_PrimePairs(){}

  /**
   * Exercise 2.2.5.
   * Calcs a list the prime pairs
   *
   * @param number up to which it is calculated
   * @return a List of prime numbers
   */
  public static HashMap<Integer, Integer> getPrimeTwinPair(int number) {
    Predicate<Integer> isTwinPair = n -> isPrime(n) && isPrime(n+2);

    var twins = new HashMap<Integer, Integer>();

    IntStream.range(0, number)
        .boxed()
        .filter(isTwinPair)
        .forEach(i -> twins.put(i, i + 2));

    return twins;
  }

  private static boolean isPrime(int number) {
    var divisors = divisorsOf(number);
    return divisors.size() == 2 && divisors.contains(1) && divisors.contains(number);
  }

  private static List<Integer> divisorsOf(int number){
    return IntStream.range(1, number + 1)
        .filter(value -> number % value == 0)
        .boxed()
        .toList();
  }
}
