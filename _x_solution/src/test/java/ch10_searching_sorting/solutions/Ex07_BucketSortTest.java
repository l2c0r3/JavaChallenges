package ch10_searching_sorting.solutions;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex07_BucketSortTest
{
    @Test
    public void testBucketSort()
    {
        final int[] values = { 10, 50, 22, 7, 42, 111, 50, 7 };
        final int max = 150;
        final int[] expected = { 7, 7, 10, 22, 42, 50, 50, 111 };

        final int[] result = Ex07_BucketSort.bucketSort(values, max);

        assertArrayEquals(expected, result);
    }
}
