package net.c0r3.javachallanges.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ex06_ChecksumTest {

  @ParameterizedTest
  @CsvSource(value = {
      "11111,5",
      "87654321,0"
  })
  void calcChecksumTest(String input, int expected){
    var actual = Ex06_Checksum.calcChecksum(input);
    assertEquals(expected, actual);
  }
}