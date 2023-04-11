package ch02_math.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex13_PrimeFactors
{
    private Ex13_PrimeFactors()
    {
    }

    static List<Integer> calcPrimeFactors(final int n)
    {
        final List<Integer> primeFactors = new ArrayList<>();

        final List<Integer> allPrimes = calcPrimesUpTo(n);

        int remainingValue = n;

        // solange gerade, immer wieder durch 2 teile
        while (remainingValue % 2 == 0 && remainingValue >= 2)
        {
            remainingValue = remainingValue / 2;
            primeFactors.add(2);
        }

        if (isPrime(allPrimes, remainingValue))
        {
            primeFactors.add(remainingValue);
        }
        else
        {
            // weitere Prüfung
            while (remainingValue > 1)
            {
                for (final Integer currentPrime : allPrimes)
                {
                    if (remainingValue % currentPrime == 0)
                    {
                        remainingValue = remainingValue / currentPrime;
                        primeFactors.add(currentPrime);
                        break; // starte nochmal von vorne, weil etwa 25 = 5 * 5
                    }
                }
            }
        }

        return primeFactors;
    }

    static List<Integer> calcPrimeFactorsOptimized(final int n)
    {
        final List<Integer> allPrimes = calcPrimesUpTo(n);

        final List<Integer> primeFactors = new ArrayList<>();

        int remainingValue = n;
        while (remainingValue > 1)
        {
            for (final Integer currentPrime : allPrimes)
            {
                while (remainingValue % currentPrime == 0)
                {
                    remainingValue = remainingValue / currentPrime;
                    primeFactors.add(currentPrime);
                }
            }
        }
        return primeFactors;
    }

    private static boolean isPrime(final List<Integer> allPrimes, final int n)
    {
        return allPrimes.contains(n);
    }

    private static List<Integer> calcPrimesUpTo(final int n)
    {
        return Ex04_PrimeNumber.calcPrimesUpTo(n);
    }
}
