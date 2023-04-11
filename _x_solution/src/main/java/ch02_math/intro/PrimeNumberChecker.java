package ch02_math.intro;

import java.util.ArrayList;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class PrimeNumberChecker
{
    public static boolean isPrime(final int potentiallyPrime)
    {
        // prüfe für alle relevanten Zahlen, ob diese einen Teiler darstellen
        for (int i = 2; i <= potentiallyPrime / 2; i++)
        {
            if (potentiallyPrime % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(final String[] args)
    {
        System.out.println(isPrime(4));
        System.out.println(isPrime(7));
        System.out.println(isPrime(42));

        final var primes = new ArrayList<>();
        for (int i = 2; i < 25; i++)
        {
            if (isPrime(i))
                primes.add(i);
        }
        System.out.println("Primes < 25:" + primes);
    }
}