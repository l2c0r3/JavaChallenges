package ch05_arrays.intro;

import java.util.Arrays;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class RemoveDuplicatesInplaceExample
{
    public static void main(final String[] args)
    {
        final int[] sortedNumbers = { 1, 2, 3, 3, 3, 4, 4, 4, 4 };

        removeDuplicatesFirstTry(sortedNumbers);
        System.out.println(Arrays.toString(sortedNumbers));

        final int[] sortedNumbers1 = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 };

        System.out.println(removeDuplicatesImproved(sortedNumbers1));
        System.out.println(Arrays.toString(sortedNumbers1));
    }

    // Mittel, wegen Inplace
    private static int[] removeDuplicatesFirstTry(int[] sortedNumbers)
    {
        // Idee: Laufe durch das Array, prüfe, bei jedem Element, ob es sich um ein
        // Duplikat handelt. Das kann man einfach dadurch machen, dass man mit dem
        // Vorgänger vergleicht. Das ist möglich, weil eine Sortieurng existiert.
        int prevValue = sortedNumbers[0];
        int writePos = 1;
        int i = 1;
        while (i < sortedNumbers.length)
        {
            final int currentValue = sortedNumbers[i];
            if (prevValue != currentValue)
            {
                // copy
                sortedNumbers[writePos] = currentValue;
                writePos++;

                prevValue = currentValue;
            }

            i++;
        }

        return sortedNumbers;
    }

    private static int removeDuplicatesImproved(final int[] sortedNumbers)
    {
        // sanity check
        if (sortedNumbers.length < 1)
            return 0;

        int writeIndex = 1;
        for (int i = 1; i < sortedNumbers.length; i++)
        {
            final int currentValue = sortedNumbers[i];
            final int prevValue = sortedNumbers[writeIndex - 1];

            if (prevValue != currentValue)
            {
                sortedNumbers[writeIndex] = sortedNumbers[i];
                writeIndex++;
            }
        }

        for (int i = writeIndex; i < sortedNumbers.length; i++)
        {
            sortedNumbers[i] = -1;
        }
        return writeIndex;
    }
}
