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
public class Ex09_SimpleBracesCheckerTest
{
    @ParameterizedTest(name="checkBraces(''{0}'') -- Hinweis: {2}" )
    @CsvSource({ "(()), true, ok",
        "()(), true, ok",
        "(()))((()), false, nicht sauber geschachtelt",
    "((), false, keine passende Klammerung" })
    void checkBraces(String input, boolean expected, String hint)
    {
        boolean result = Ex09_SimpleBracesChecker.checkBraces(input);

        assertEquals(expected, result);
    }
}
