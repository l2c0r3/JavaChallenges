package ch10_searching_sorting.solutions;

import ch05_arrays.util.ArrayUtils;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex04_InsertionSort
{
    private Ex04_InsertionSort()
    {
    }

    public static void insertionSort(int[] values)
    {
        for (int i = 1; i < values.length; i++)
        {
            // Prüfe, ob aktuelles Element grösser als Vorgänger
            int currentIdx = i;
            while (currentIdx > 0 && values[currentIdx - 1] > values[currentIdx])
            {
                ArrayUtils.swap(values, currentIdx - 1, currentIdx);
                currentIdx--;
            }
        }
    }
}