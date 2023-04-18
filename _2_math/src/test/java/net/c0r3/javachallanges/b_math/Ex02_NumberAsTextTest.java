package net.c0r3.javachallanges.b_math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ex02_NumberAsTextTest {

  @ParameterizedTest
  @CsvSource(value = {"7,SEVEN", "42,FOUR TWO", "24680, TWO FOUR SIX EIGHT ZERO", "13579,ONE THREE FIVE SEVEN NINE"})
  void numberAsTextString(int number, String expectedText) {
    var actual = Ex02_NumberAsText.numberAsText(number);
    assertEquals(expectedText, actual);
  }

}