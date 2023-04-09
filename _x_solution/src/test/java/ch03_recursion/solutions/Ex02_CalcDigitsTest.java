package ch03_recursion.solutions;

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
public class Ex02_CalcDigitsTest
{
    @ParameterizedTest(name = "calcDigits({0}) = {1}")
    @CsvSource({ "1234, 4", "1234567, 7" })
    public void calcDigits(int number, int expected) throws Exception
    {
        long result = Ex02_CalcDigits.calcDigits(number);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "calcSumOfDigits({0}) = {1}")
    @CsvSource({ "1234, 10", "1234567, 28" })
    public void calcSumOfDigits(int number, int expected) throws Exception
    {
        long result = Ex02_CalcDigits.calcSumOfDigits(number);

        assertEquals(expected, result);
    }
}
