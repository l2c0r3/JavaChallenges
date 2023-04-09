package ch10_searching_sorting.solutions;

import ch05_arrays.util.ArrayUtils;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex01_ContainsAll
{
    private Ex01_ContainsAll()
    {
    }

    public static boolean containsAll(final int[] values, final int... searchFor)
    {
        for (int current : searchFor)
        {
            if (!ArrayUtils.contains(values, current))
            {
                return false;
            }
        }

        return true;
    }
}
