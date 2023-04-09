package ch03_recursion.intro;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class FractalGenerator
{
    public static void main(String[] args)
    {
        //fractalGenerator(1);
        //fractalGenerator(2);
        //fractalGenerator(4);

        fractalGenerator(3);
    }

    private static void fractalGenerator(final int n)
    {
        if (n == 1)
        {
            System.out.println("-");
        }
        else
        {
            fractalGenerator(n - 1);
            System.out.println("=".repeat(n));
            fractalGenerator(n - 1);
        }
    }

    private static void fractalGenerator2(final int n)
    {
        if (n == 1)
        {
            System.out.println("-");
        }
        else
        {
            System.out.println("*".repeat(n));
            fractalGenerator(n - 1);
            fractalGenerator(n - 1);
        }
    }
}
