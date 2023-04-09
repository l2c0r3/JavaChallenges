package ch03_recursion.solutions;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex02_CalcDigits
{
    private Ex02_CalcDigits()
    {
    }

    static int calcDigits(final int value)
    {
        if (value < 0)
            throw new IllegalArgumentException("i must be >= 0");

        if (value < 10)
            return 1;

        final int remainder = value / 10;

        return calcDigits(remainder) + 1;
    }

    static int calcSumOfDigits(final int value)
    {
        if (value < 0)
            throw new IllegalArgumentException("i must be >= 0");

        if (value < 10)
            return value;

        final int remainder = value / 10;
        final int lastDigit = value % 10;

        return calcSumOfDigits(remainder) + lastDigit;
    }
}
