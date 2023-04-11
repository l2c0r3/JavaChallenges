package ch06_dateprocessing.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Year;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex01_LeapYearTest
{
    @ParameterizedTest(name="isLeap({0} => {2}, Hinweis: {1}")
    @CsvSource( { "1900, Säkulär, false",
        "2000, Säkular (aber 400er-Regel), true",
    "2020, jedes 4. Jahr, true"})
    void testIsLeap(final int year, final String hint, final boolean expected)
    {
        final boolean result = Ex01_LeapYear.isLeap(year);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name="isLeap({0} => {2}, Hinweis: {1}")
    @CsvSource( { "1900, Säkulär, false",
        "2000, Säkular (aber 400er-Regel), true",
    "2020, jedes 4. Jahr, true"})
    void testIsLeapJdk(final int year, final String hint, final boolean expected)
    {
        final boolean result = Year.isLeap(year);

        assertEquals(expected, result);
    }
}
