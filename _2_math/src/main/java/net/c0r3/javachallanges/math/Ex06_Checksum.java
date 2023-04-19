package net.c0r3.javachallanges.math;

public class Ex06_Checksum {

  /**
   * Exercise 2.2.6.
   * Calcs a checksum for a number in string format
   *
   * (1 * z1 + 2 * z2 ... ) % 10
   *
   * @param number number in string format
   * @return checksum
   */
  public static int calcChecksum(String number) {
    var arr = number.toCharArray();
    var sum = 0;
    for (int i = 0; i < arr.length; i++) {
//      sum += (i + 1) * Integer.valueOf(String.valueOf(arr[i]));
      // TODO: Big learning: https://stackoverflow.com/questions/12927087/what-does-string-0-do-string-is-a-char
      sum += (i + 1) * (arr[i] - '0');
    }
    return sum % 10;
  }
}
