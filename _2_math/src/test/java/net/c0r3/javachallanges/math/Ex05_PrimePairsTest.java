package net.c0r3.javachallanges.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class Ex05_PrimePairsTest {

  @Test
  void getPrimeTwinPair() {
    var expected = new HashMap<Integer, Integer>() {{
      put(3,5);
      put(5,7);
      put(11,13);
      put(17,19);
      put(29,31);
      put(41,43);
    }};
    var actual = Ex05_PrimePairs.getPrimeTwinPair(50);
    assertEquals(expected, actual);
  }

}