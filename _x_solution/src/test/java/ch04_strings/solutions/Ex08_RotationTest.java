package ch04_strings.solutions;

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
public class Ex08_RotationTest
{
    @ParameterizedTest(name = "{1} in {0}{0} => {2}")
    @CsvSource({ "ABCD, ABC, true", "ABCDEF, EFAB, true", "BCDE, EC, false", "Challenge, GECH, true" })
    public void containsRotation(String value, String rotatedSub, boolean expected)
    {
        boolean result = Ex08_Rotation.containsRotation(value, rotatedSub);

        assertEquals(expected, result);
    }
}
