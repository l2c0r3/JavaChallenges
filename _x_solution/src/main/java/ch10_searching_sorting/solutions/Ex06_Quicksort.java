package ch10_searching_sorting.solutions;

import ch05_arrays.util.ArrayUtils;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex06_Quicksort
{
    private Ex06_Quicksort()
    {
    }

    public static void quickSort(final int[] values)
    {
        quicksort(values, 0, values.length - 1);
    }

    public static void quicksort(final int[] values, final int left, final int right)
    {
        // rekursiver Abbruch
        if (left >= right)
            return;

        final int partitionIndex = partition(values, left, right);

        // rekursiver Abstieg
        quicksort(values, left, partitionIndex - 1);
        quicksort(values, partitionIndex + 1, right);
    }


    static int partition(final int[] values, final int left, final int right)
    {
        final int pivot = values[left];

        int leftIndex = left + 1;
        int rightIndex = right;

        while (leftIndex < rightIndex)
        {
            // Bewege die Position leftIndex nach rechts, so lange Wert kleiner gleich
            // Pivot und linke Grenze kleiner als rechte Grenze
            while (values[leftIndex] <= pivot && leftIndex < rightIndex)
            {
                leftIndex++;
            }

            // Bewege die Position rightIndex nach links, so lange Wert größer als
            // Pivot und rechte Grenze größer oder gleich linke Grenze
            while (pivot < values[rightIndex] && rightIndex >= leftIndex)
            {
                rightIndex--;
            }

            if (leftIndex < rightIndex)
                ArrayUtils.swap(values, leftIndex, rightIndex);
        }

        // Spezialfall 2-elementiges Array mit falscher Sortierung, aber kein
        // Durchlauf (wg. leftIndex == rightIndex) sowie Normalfall ganz am Ende
        if (values[rightIndex] < pivot)
            ArrayUtils.swap(values, left, rightIndex);

        return rightIndex;
    }
}