package ch02_math.solutions;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
// Optimierung von O(n3) auf O(n2)
public class Ex08_QuadraticSolver2_Improved_On2
{
    private Ex08_QuadraticSolver2_Improved_On2()
    {
    }

    public static void main(final String[] args)
    {
        // verschachtelte Schleifen
        for (int a = 1; a < 100; a++)
        {
            for (int b = 1; b < 100; b++)
            {
                final int c = (int) Math.sqrt(a * a + b * b);
                if (a * a + b * b == c * c)
                {
                    System.out.println("a = " + a + " / b = " + b + " / c = " + c);
                }
            }
        }
    }
}
