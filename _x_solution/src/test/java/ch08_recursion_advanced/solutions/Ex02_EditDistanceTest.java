package ch08_recursion_advanced.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex02_EditDistanceTest
{
    @ParameterizedTest(name = "edit distance between {0} and {1} is {2}")
    @CsvSource({ "Micha, Michael, 2", "Ananas, Banane, 3" })
    public void editDistance(String input1, String input2, int expected)
    {
        var result = Ex02_EditDistance.editDistance(input1, input2);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "edit distance between {0} and {1} is {2}")
    @CsvSource({ "Micha, Michael, 2", "Ananas, Banane, 3" })
    public void editDistanceOptimized(String input1, String input2, int expected)
    {
        var result = Ex02_EditDistance.editDistanceOptimized(input1, input2);

        assertEquals(expected, result);
    }

}
