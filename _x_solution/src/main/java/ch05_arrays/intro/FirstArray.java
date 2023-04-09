package ch05_arrays.intro;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class FirstArray
{
    public static void main(final String[] args)
    {
        final char[] greeting = "Hello".toCharArray();
        printArray(greeting);
    }

    public static void printArray(final char[] values)
    {
        for (int i= 0; i < values.length; i++)
        {
            final char ch = values[i];
            System.out.println(ch);
        }
    }
}
