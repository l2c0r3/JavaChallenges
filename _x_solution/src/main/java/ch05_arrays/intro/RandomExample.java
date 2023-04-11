package ch05_arrays.intro;

import java.util.Random;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class RandomExample
{
    public static void main(final String[] args)
    {
        final Random random = new Random();

        // Ganzahlige Zufallszahl zwischen 0 (inklusiv) und 10 (exklusiv)
        final int randomNumberInt = random.nextInt(10);

        final double randomNumberDouble = random.nextDouble();

        System.out.println(randomNumberInt);
        System.out.println(randomNumberDouble);
    }
}
