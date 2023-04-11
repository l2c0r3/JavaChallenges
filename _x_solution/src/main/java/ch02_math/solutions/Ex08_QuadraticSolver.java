package ch02_math.solutions;


/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex08_QuadraticSolver {

    public static void main(final String[] args)
    {
        // brute force, drei verschachtelte Schleifen
        for (int a = 1; a < 100;a++)
        {
            for (int b = 1; b < 100; b++)
            {
                for (int c = 1; c < 100; c++)
                {
                    if (a * a + b * b == c * c)
                    {
                        System.out.println("a = " + a + " / b = " + b + " / c = " + c);
                    }

                    // Alternative
                    // Achtung double
                    /*
					if ((Math.pow(a,2)) + Math.pow(b,2) == Math.pow(c,2))
					{
						System.out.println("a = " + a + " / b = " + b + " / c = " + c);
					}
                     */
                }
            }
        }
    }
}
