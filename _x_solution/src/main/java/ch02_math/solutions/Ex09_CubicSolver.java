package ch02_math.solutions;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex09_CubicSolver
{
    private Ex09_CubicSolver()
    {
    }

    public static void main(final String[] args)
    {
        // brute force, verschachtelte Schleifen
        for (int a = 1; a < 100;a++)
        {
            for (int b = 1; b < 100; b++)
            {
                for (int c = 1; c < 100; c++)
                {
                    for (int d = 1; d < 100; d++)
                    {
                        if (a * a + b * b == c * c + d * d)
                        {
                            System.out.println("a = " + a + " / b = " + b + " / c = " + c + " / d = " + d);
                        }
                    }
                }
            }
        }
    }
}
