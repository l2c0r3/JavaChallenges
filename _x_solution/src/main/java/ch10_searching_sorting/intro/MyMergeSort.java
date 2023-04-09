package ch10_searching_sorting.intro;

import java.util.Arrays;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class MyMergeSort
{
    public static void main(final String[] args)
    {
        final int[] unsorted = { 7, 2, 6, 3, 4, 5, 8, 1, 9 };

        final int[] sorted = mergesort(unsorted);
        System.out.println(Arrays.toString(sorted));

        final int[] unsorted2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        final int[] sorted2 = mergesort(unsorted2);
        System.out.println(Arrays.toString(sorted2));

        final int[] unsorted3 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        final int[] sorted3 = mergesort(unsorted3);
        System.out.println(Arrays.toString(sorted3));

        final int[] unsorted4 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        final int[] sorted4 = mergesortInplace(unsorted4);
        System.out.println(Arrays.toString(sorted4));
    }

    static int[] mergesort(final int[] toSort)
    {
        if (toSort.length == 0 || toSort.length == 1)
        {
            return toSort;
        }

        final int midPos = toSort.length / 2;

        // divide again
        final int[] left = Arrays.copyOfRange(toSort, 0, midPos);
        final int[] resultLeft = mergesort(left);

        final int[] right = Arrays.copyOfRange(toSort, midPos, toSort.length);
        final int[] resultRight = mergesort(right);

        // merge
        return merge(resultLeft, resultRight);
    }

    private static int[] merge(int[] first, int[] second)
    {
        int length1 = first.length;
        int length2 = second.length;

        int[] result = new int[length1 + length2];

        //
        int pos1 = 0;
        int pos2 = 0;
        int idx = 0;

        // Durchlaufe solange die beiden Positionszeiger unter der Länge sind
        while (pos1 < length1 && pos2 < length2)
        {
            int value1 = first[pos1];
            int value2 = second[pos2];

            if (value1 < value2)
            {
                result[idx] = value1;
                idx++;
                pos1++;
            }
            else
            {
                result[idx] = value2;
                idx++;
                pos2++;
            }
        }

        // collect the remaining if any
        while (pos1 < length1)
        {
            result[idx] = first[pos1];
            idx++;
            pos1++;
        }

        while (pos2 < length2)
        {
            result[idx] = second[pos2];
            idx++;
            pos2++;
        }

        return result;
    }

    // Inplace
    static int[] mergesortInplace(int[] toSort)
    {
        return mergesortInplace(toSort, 0, toSort.length - 1);
    }

    static int[] mergesortInplace(int[] toSort, int l, int r)
    {
        if (l < r)
        {
            final int midPos = (l + r) / 2; // =>  l + (r - l) / 2; // Same as (l + r) / 2, but avoids overflow for large l and r

            mergesortInplace(toSort, l, midPos);
            mergesortInplace(toSort, midPos + 1, r);

            return mergeInplace(toSort, l, midPos, r);
        }

        return toSort;
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    // Inplace Implementation
    static int[] mergeInplace(int arr[], int start, int mid, int end)
    {
        int start2 = mid + 1;

        // If the direct merge is already sorted
        if (arr[mid] <= arr[start2])
        {
            return arr;
        }

        // Two pointers to maintain start
        // of both arrays to merge
        while (start <= mid && start2 <= end)
        {

            // If element 1 is in right place
            if (arr[start] <= arr[start2])
            {
                start++;
            }
            else
            {
                int value = arr[start2];
                int index = start2;

                // Shift all the elements between element 1
                // element 2, right by 1.
                while (index != start)
                {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start] = value;

                // Update all the pointers
                start++;
                mid++;
                start2++;
            }
        }

        return arr;
    }

}
