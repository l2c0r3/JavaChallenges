package net.c0r3.javachallanges.b_math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ex01_BasicTest {

  @ParameterizedTest
  @CsvSource(value = {"6,7,0", "3,4,6", "5,5,5"})
  void basicTest(int param1, int param2, int expected) {
    var actual = Ex01_Basic.calc(param1, param2);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource(value = {"3,1,2", "8,4,19", "15,8,63"})
  void calcSumAndCountAllNumberDivBy2Or7Test(int x, int count, int sum) {
    var actual = Ex01_Basic.calcSumAndCountAllNumberDivBy2Or7(x);
    assertEquals(count, actual.count());
    assertEquals(sum, actual.sum());
  }

}