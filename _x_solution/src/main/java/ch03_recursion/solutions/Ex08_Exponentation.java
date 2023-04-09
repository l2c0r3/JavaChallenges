package ch03_recursion.solutions;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex08_Exponentation
{
    private Ex08_Exponentation()
    {
    }

    public static boolean isPowerOf2(final int n)
    {
        if (n < 2)
            return n == 1;

        if (n % 2 != 0)
            return false;

        return isPowerOf2(n / 2);
    }

    static boolean isPowerOf2Short(final int n)
    {
        return n == 1 || n > 0 && n % 2 == 0 && isPowerOf2(n / 2);
    }

    // Algorithmus: Rufe die Methode exponent - 1 mal selbst auf und
    // multipliziere die Zahl mit dem Ergebnis des Selsbtaufrufs,
    // Reduziere bei jedem Aufruf den exponent und Abbruch bei Exponent 1 oder 0.
    public static long powerOf(final int value, final int exponent)
    {
        if (exponent < 0)
            throw new IllegalArgumentException("exponent must be >= 0");

        if (exponent == 0)
            return 1;

        if (exponent == 1)
            return value;

        return value * powerOf(value, exponent - 1);
    }

    static long powerOfOptimized(final long value, final int exponent)
    {
        if (exponent < 0)
            throw new IllegalArgumentException("exponent must be >= 0");

        // rekursiver Abbruch
        if (exponent == 0)
            return 1;

        if (exponent == 1)
            return value;

        // rekursiver Abstieg
        long result = powerOfOptimized(value * value, exponent / 2);
        if (exponent % 2 == 1)
            return value * result;

        return result;
    }

    static long powerOfIterative(int value, int exponent)
    {
        if (exponent == 0)
            return 1;

        if (exponent == 1)
            return value;

        long result = 1;
        while (exponent > 0)
        {
            result *= value;
            exponent--;
        }

        return result;
    }
}
