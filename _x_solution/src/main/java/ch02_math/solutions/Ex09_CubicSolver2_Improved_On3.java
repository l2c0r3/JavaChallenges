package ch02_math.solutions;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex09_CubicSolver2_Improved_On3
{
    private Ex09_CubicSolver2_Improved_On3()
    {
    }

    public static void main(final String[] args)
    {
        // brute force, drei verschachtelte Schleifen
        for (int a = 1; a < 100; a++)
        {
            for (int b = 1; b < 100; b++)
            {
                for (int c = 1; c < 100; c++)
                {
                    final int value = a * a + b * b - c * c;
                    if (value > 0)
                    {
                        final int d = (int) Math.sqrt(a * a + b * b - c * c);

                        if (d < 100 && a * a + b * b == c * c + d * d)
                        {
                            System.out.println("a = " + a + " / b = " + b + " / c = " + c + " / d = " + d);
                        }
                    }
                }
            }
        }
    }
}
