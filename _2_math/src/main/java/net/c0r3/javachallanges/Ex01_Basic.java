package net.c0r3.javachallanges;

import java.util.ArrayList;

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
    var foundNumbers = new ArrayList<Integer>();

    for (int i = 1; i < x; i++) {

      if (i % 2 == 0) {
        foundNumbers.add(i);
      } else if (i % 7 == 0) {
        foundNumbers.add(i);
      }
    }

    var sum =  foundNumbers.stream().reduce(Integer::sum).orElse(0);
    return new ResultCalcSumAndCount(sum, foundNumbers.size());
  }
  


}