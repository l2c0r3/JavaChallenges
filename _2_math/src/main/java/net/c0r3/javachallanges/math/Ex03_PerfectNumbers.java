package net.c0r3.javachallanges.math;

import java.util.List;
import java.util.stream.IntStream;

public class Ex03_PerfectNumbers {

  private Ex03_PerfectNumbers(){}

  /**
   * Exercise 2.2.3.
   * Returns a List of perfect numbers up to the parameter.
   *
   * @param max The number up to which it is calculated
   * @return the List of perfect numbers
   */
  public static List<Integer> calcPerfectNumber(int max) {
    return IntStream.range(1, max)
        .boxed()
        .filter(Ex03_PerfectNumbers::isPerfectNumber)
        .toList();
  }

  private static Boolean isPerfectNumber(Integer number) {
    var sumOfDivisors = divisorsOf(number).stream()
        .filter(i -> !i.equals(number))
        .reduce(Integer::sum)
        .orElse(0);
    return sumOfDivisors.equals(number);
  }

  private static List<Integer> divisorsOf(int number){
    return IntStream.range(1, number + 1)
        .filter(value -> number % value == 0)
        .boxed()
        .toList();
  }
}
