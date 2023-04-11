package ch03_recursion.solutions;

import java.math.BigInteger;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex01_Fibonacci
{
    private Ex01_Fibonacci()
    {
    }

    static long fibRec(final int n)
    {
        if (n <= 0)
            throw new IllegalArgumentException("must be positive and >= 1");

        // rekursiver Abbruch
        if (n == 1 || n == 2)
            return 1;

        // rekursiver Abstieg
        return fibRec(n - 1) + fibRec(n - 2);
    }

    static long fibIterative(final int n)
    {
        if (n <= 0)
            throw new IllegalArgumentException("must be >= 1");

        if (n == 1 || n == 2)
            return 1;

        long fibN_2 = 1;
        long fibN_1 = 1;

        for (int count = 2; count < n; count++)
        {
            final long fibN = fibN_1 + fibN_2;

            fibN_2 = fibN_1;
            fibN_1 = fibN;
        }

        return fibN_1;
    }

    static BigInteger fibBigInt(int n)
    {
        if (n <= 0)
            throw new IllegalArgumentException("must be >= 1");

        if (n == 1 || n == 2)
            return BigInteger.ONE;

        BigInteger fibN_2 = BigInteger.ONE;
        BigInteger fibN_1 = BigInteger.ONE;

        int count = 2;
        while (count < n)
        {
            final BigInteger fibN = fibN_1.add(fibN_2);

            fibN_2 = fibN_1;
            fibN_1 = fibN;

            count++;
        }

        return fibN_1;
    }
}
