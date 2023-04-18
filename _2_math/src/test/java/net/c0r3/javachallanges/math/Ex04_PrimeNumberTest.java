package net.c0r3.javachallanges.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Ex04_PrimeNumberTest {

  @ParameterizedTest
  @MethodSource("calcPrimeNumbersData")
  void calcPrimeNumbersTest(int number, List<Integer> expectedPerfectNumbers) {
    var actual = Ex04_PrimeNumber.calcPrimesUpTo(number);
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