package ch02_math.intro;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 * 
 * @author Michael Inden
 * 
 * Copyright 2020 by Michael Inden 
 */
public class ExtractDigitsExample
{
    public static void main(final String[] args)
    {
        extractDigits(7);

        extractDigits(1234567);
    }

    private static void extractDigits(final int startValue)
    {
        int remainingValue = startValue;

        while (remainingValue > 0)
        {
            int digit = remainingValue % 10;

            System.out.print(digit + " ");

            remainingValue = remainingValue / 10;
        }

        System.out.println();
    }
}
