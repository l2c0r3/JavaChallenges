package ch02_math.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex12_BefreundeteZahlen
{
    private Ex12_BefreundeteZahlen()
    {
    }

    static Map<Integer, Integer> calcFriends(final int max)
    {
        final Map<Integer, Integer> friends = new TreeMap<>();

        for (int i= 2; i < max; i++)
        {
            final List<Integer> divisors = findProperDivisors(i);
            final int sumDiv = sum(divisors);

            final List<Integer> divisors2 = findProperDivisors(sumDiv);
            final int sum2 = sum(divisors2);

            if (i == sum2 && sumDiv != sum2)
            {
                friends.put(i, sumDiv);
            }
        }

        return friends;
    }


    private static int sum(final List<Integer> values)
    {
        return values.stream().mapToInt(n->n).sum();
    }

    private static List<Integer> findProperDivisors(final int value)
    {
        final List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= value / 2; i++)
        {
            if (value % i == 0)
            {
                divisors.add(i);
            }
        }

        return divisors;
    }
}
