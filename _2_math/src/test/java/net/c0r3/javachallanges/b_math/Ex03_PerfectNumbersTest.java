package net.c0r3.javachallanges.b_math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Ex03_PerfectNumbersTest {

  @ParameterizedTest
  @MethodSource("calcPerfectNumberData")
  void calcPerfectNumber(int number, List<Integer> expectedPerfectNumbers) {
    var actual = Ex03_PerfectNumbers.calcPerfectNumber(number);
    assertEquals(expectedPerfectNumbers, actual);
  }

  static Stream<Arguments> calcPerfectNumberData() {
    return Stream.of(
        Arguments.of(1_000, List.of(6,28,496)),
        Arguments.of(10_000, List.of(6,28,496,8128))
    );
  }

}