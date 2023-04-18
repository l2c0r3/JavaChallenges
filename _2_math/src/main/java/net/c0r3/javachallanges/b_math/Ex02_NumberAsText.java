package net.c0r3.javachallanges.b_math;

public class Ex02_NumberAsText {

  private Ex02_NumberAsText(){}

  /**
   * Exercise 2.2.2
   */
  public static String numberAsText(final int n) {
    final int remainder = n % 10;
    String valueAsText;

    switch (remainder) {
      case 0 -> valueAsText = "ZERO";
      case 1 -> valueAsText = "ONE";
      case 2 -> valueAsText = "TWO";
      case 3 -> valueAsText = "THREE";
      case 4 -> valueAsText = "FOUR";
      case 5 -> valueAsText = "FIVE";
      case 6 -> valueAsText = "SIX";
      case 7 -> valueAsText = "SEVEN";
      case 8 -> valueAsText = "EIGHT";
      case 9 -> valueAsText = "NINE";
      default -> valueAsText = "UNKNOWN";
    }

    if (remainder == n) {
      return valueAsText;
    }
    return numberAsText(n / 10) + " " +valueAsText;
  }
}
