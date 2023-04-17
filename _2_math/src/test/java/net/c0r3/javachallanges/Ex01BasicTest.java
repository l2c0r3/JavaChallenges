package net.c0r3.javachallanges;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex01BasicTest {

  @ParameterizedTest
  @CsvSource(value = {"6,7,0", "3,4,6", "5,5,5"})
  void basicTest(int param1, int param2, int expected) {
    var actual = Ex01Basic.calc(param1, param2);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource(value = {"3,1,2", "8,4,19", "15,8,63"})
  void calcSumAndCountAllNumberDivBy2Or7Test(int x, int count, int sum) {
    var actual = Ex01Basic.calcSumAndCountAllNumberDivBy2Or7(x);
    assertEquals(count, actual.count());
    assertEquals(sum, actual.sum());
  }

  @ParameterizedTest
  @CsvSource(value = {"7,SEVEN", "42,FOUR TWO", "24680, TWO FOUR SIX EIGHT ZERO", "13579,ONE THREE FIVE SEVEN NINE"})
  void numberAsTextString(int number, String expectedText) {
    var actual = Ex01Basic.numberAsText(number);
    assertEquals(expectedText, actual);
  }

  @ParameterizedTest
  @MethodSource("calcPerfectNumberData")
  void calcPerfectNumber(int number, List<Integer> expectedPerfectNumbers) {
    var actual = Ex01Basic.calcPerfectNumber(number);
    assertEquals(expectedPerfectNumbers, actual);
  }

  static Stream<Arguments> calcPerfectNumberData() {
    return Stream.of(
            Arguments.of(1_000, List.of(6,28,496)),
            Arguments.of(10_000, List.of(6,28,496,8128))
    );
  }

  @ParameterizedTest
  @MethodSource("calcPrimeNumbersData")
  void calcPrimeNumbersTest(int number, List<Integer> expectedPerfectNumbers) {
    var actual = Ex01Basic.calcPrimesUpTo(number);
    assertEquals(expectedPerfectNumbers, actual);
  }

  static Stream<Arguments> calcPrimeNumbersData() {
    return Stream.of(
        Arguments.of(15, List.of(2,3,5,7,11,13)),
        Arguments.of(25, List.of(2,3,5,7,11,13,17,19,23)),
        Arguments.of(50, List.of(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47))
    );
  }
}