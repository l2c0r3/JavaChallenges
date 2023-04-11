package ch03_recursion.intro;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Fakultaet
{
    public static void main(final String[] args)
    {
        System.out.println(fac(5));
        System.out.println(fac(7));
    }

    static int fac(final int n)
    {
        if (n == 1)
            return 1;

        return n * fac(n-1);
    }
}
