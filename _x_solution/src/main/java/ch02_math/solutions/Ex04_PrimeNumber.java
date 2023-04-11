package ch02_math.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex04_PrimeNumber
{
    private Ex04_PrimeNumber()
    {
    }

    public static List<Integer> calcPrimesUpTo(final int maxValue)
    {
        // initial alle als potenzielle Primzahl markieren
        final boolean[] isPotentiallyPrime = new boolean[maxValue + 1];
        Arrays.fill(isPotentiallyPrime, true);

        // Durchlaufe alle Zahlen startend bei 2,
        // vereinfacht muss nur bis zur Hälfte gesucht werden,
        // da danach dann Vielfache von 2
        for (int i = 2; i <= maxValue / 2; i++)
        {
            if (isPotentiallyPrime[i])
            {
                // alle Vielfachen "ausradieren" (immer um die derzeitige Zahl erhöhen)
                eraseMultiplesOfCurrent(isPotentiallyPrime, i);
            }
        }

        // Ergebnis ermitteln ==> könnte man direkt im Loop oben machen, aber schlechter lesbar
        return buildPrimesList(isPotentiallyPrime);
    }

    static List<Integer> buildPrimesList(final boolean[] isPotentiallyPrime)
    {
        final List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isPotentiallyPrime.length; i++)
        {
            if (isPotentiallyPrime[i])
                primes.add(i);
        }
        return primes;
    }

    private static void eraseMultiplesOfCurrent(final boolean[] isPotentiallyPrime, final int i)
    {
        for (int n = i + i; n < isPotentiallyPrime.length; n = n + i)
        {
            isPotentiallyPrime[n] = false;
            // System.out.println("Eliminating " + n);
        }
    }
}
