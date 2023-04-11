package net.c0r3.javachallanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Exercise 2.2
 */
public class Ex01_Basic {

  /**
   * Exercise 2.2.1 a
   */
  public static int calc(int m, int n) {
    return n * m / 2 % 7;
  }


  /**
   * Exercise 2.2.1 b
   */
  record ResultCalcSumAndCount(int sum, int count){}
  public static ResultCalcSumAndCount calcSumAndCountAllNumberDivBy_2_Or_7(int x) {
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
}