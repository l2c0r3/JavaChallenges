package ch10_searching_sorting.solutions;

import ch05_arrays.util.ArrayUtils;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex02_FlagPartitioning
{
    private Ex02_FlagPartitioning()
    {
    }

    public static String partition2(final String charValues)
    {
        return partition2(charValues.toCharArray());
    }

    public static String partition2(final char[] charValues)
    {
        int low = 0;
        int high = charValues.length - 1;

        while (low <= high)
        {
            if (charValues[low] == 'A')
                low++;
            else
            {
                ArrayUtils.swap(charValues, low, high);

                high--;
                // low muss bleiben, weil ja theoretisch auch ein B nach
                // vorne getauscht werden kann
            }
        }

        return new String(charValues);
    }

    public static String partition3(final String charValues)
    {
        return partition3(charValues.toCharArray());
    }

    public static String partition3(final char[] charValues)
    {
        int low = 0;
        int mid = 0;
        int high = charValues.length - 1;

        while (mid <= high)
        {
            if (charValues[mid] == 'A')
            {
                ArrayUtils.swap(charValues, low, mid);

                low++;
                mid++;
            }
            else if (charValues[mid] == 'B')
                mid++;
            else
            {
                ArrayUtils.swap(charValues, mid, high);

                high--;
                // low, mid muss bleiben, weil ja theoretisch auch ein B, C nach
                // vorne getauscht werden kann
            }
        }

        return new String(charValues);
    }
}
