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
public class Ex03_LCSTest
{
    @ParameterizedTest(name = "lcs({0}, {1}) = {2}")
    @CsvSource({ "ABCE, ZACEF, ACE", "ABCXY, XYACB, AB", "ABCMIXCHXAEL, MICHAEL, MICHAEL" })
    public void lcs(String input1, String input2, String expected)
    {
        var result = Ex03_LCS.lcs(input1, input2);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "lcs({0}, {1}) = {2}")
    @CsvSource({ "ABCE, ZACEF, ACE", "ABCXY, XYACB, AB", "ABCMIXCHXAEL, MICHAEL, MICHAEL" })
    public void lcsOptimized(String input1, String input2, String expected)
    {
        var result = Ex03_LCS.lcsOptimized(input1, input2);

        assertEquals(expected, result);
    }
}