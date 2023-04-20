package net.c0r3.javachallanges.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ex07_RomanTest {

  @ParameterizedTest
  @CsvSource(value = {
      "XVII,17",
      "CDXLIV,444",
      "MCMLXXI,1971",
      "MMXX,2020"
  })
  void calcChecksumTest(String roman, int expected){
    var actual = Ex07_Roman.fromRomanNumber(roman);
    assertEquals(expected, actual);
  }

}