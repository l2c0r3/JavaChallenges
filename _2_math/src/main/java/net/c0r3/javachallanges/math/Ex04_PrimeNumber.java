package net.c0r3.javachallanges.math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ex04_PrimeNumber {

  private Ex04_PrimeNumber(){}

  /**
   * Exercise 2.2.4.
   * Calcs a list the prime number up to the parameter with the "sieb des eratosthenes"
   *
   * @param number up to which it is calculated
   * @return a List of prime numbers
   */
  public static List<Integer> calcPrimesUpTo(int number) {
    // TODO: Solution has better approach

    var multipleOfPrimeNumber = new ArrayList<Integer>();
    var primes = new ArrayList<Integer>();

    IntStream.range(2, number)
        .boxed()
        .forEach(i -> {
          if (!multipleOfPrimeNumber.contains(i) && isPrime(i)) {
            primes.add(i);
            int mutlipleOfFoundPrime = i;
            while (mutlipleOfFoundPrime * 2 <= number) {
              mutlipleOfFoundPrime = mutlipleOfFoundPrime * 2;
              multipleOfPrimeNumber.add(mutlipleOfFoundPrime);
            }
          }
        });

    return primes;
  }

  private static boolean isPrime(int number) {
    var divisors = divisorsOf(number);
    return divisors.size() == 2 && divisors.contains(1) && divisors.contains(number);
  }

  private static List<Integer> divisorsOf(int number){
    return IntStream.range(1, number + 1)
        .filter(value -> number % value == 0)
        .boxed()
        .toList();
  }
}
