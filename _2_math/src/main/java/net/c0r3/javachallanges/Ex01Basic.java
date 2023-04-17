package net.c0r3.javachallanges;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Exercise 2.2
 */
public class Ex01Basic {

  /**
   * Exercise 2.2.1 a
   */
  public static int calc(int m, int n) {
    return n * m / 2 % 7;
  }


  /**
   * Exercise 2.2.1 b.
   */
  record ResultCalcSumAndCount(int sum, int count){}
  public static ResultCalcSumAndCount calcSumAndCountAllNumberDivBy2Or7(int x) {
    var numbers = IntStream.range(1, x)
        .filter(i -> isEven(i) || (i % 7 == 0))
        .boxed()
        .toList();

    var sum = numbers.stream().reduce(Integer::sum).orElse(0);

    return new ResultCalcSumAndCount(sum, numbers.size());
  }
  public static boolean isEven(int x) {
    return x % 2 == 0;
  }

  /**
   * Exercise 2.2.2
   */
  public static String numberAsText(final int n) {
    final int remainder = n % 10;
    String valueAsText;

    switch (remainder) {
      case 0 -> valueAsText = "ZERO";
      case 1 -> valueAsText = "ONE";
      case 2 -> valueAsText = "TWO";
      case 3 -> valueAsText = "THREE";
      case 4 -> valueAsText = "FOUR";
      case 5 -> valueAsText = "FIVE";
      case 6 -> valueAsText = "SIX";
      case 7 -> valueAsText = "SEVEN";
      case 8 -> valueAsText = "EIGHT";
      case 9 -> valueAsText = "NINE";
      default -> valueAsText = "UNKNOWN";
    }

    if (remainder == n) {
      return valueAsText;
    }
    return numberAsText(n / 10) + " " +valueAsText;
  }

  /**
   * Excercise 2.2.3.
   * Returns a List of perfect numbers up to the parameter.
   *
   * @param max The number up to which it is calculated
   * @return the List of perfect numbers
   */
  public static List<Integer> calcPerfectNumber(int max) {
    return IntStream.range(1, max)
            .boxed()
            .filter(Ex01Basic::isPerfectNumber)
            .toList();
  }

  private static Boolean isPerfectNumber(Integer number) {
    var sumOfDivisors = divisorsOf(number).stream()
            .reduce(Integer::sum)
            .orElse(0);
    return sumOfDivisors.equals(number);
  }

  private static List<Integer> divisorsOf(int number){
    return IntStream.range(1, number)
            .filter(value -> number % value == 0)
            .boxed()
            .toList();
  }
}