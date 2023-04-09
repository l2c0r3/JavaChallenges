package ch10_searching_sorting.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex02_FlagPartioningTest
{
    @Test
    public void testPartition2()
    {
        final String result = Ex02_FlagPartitioning.partition2("ABAABBBAAABBBA");

        assertEquals("AAAAAAABBBBBBB", result);
    }

    @Test
    public void testPartition3()
    {
        final String result = Ex02_FlagPartitioning.partition3("ABACCBBCAACCBBA");

        assertEquals("AAAAABBBBBCCCCC", result);
    }
}
