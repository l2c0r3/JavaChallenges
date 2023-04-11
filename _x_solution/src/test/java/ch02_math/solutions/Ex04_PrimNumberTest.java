package ch02_math.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex04_PrimNumberTest
{
    @ParameterizedTest(name = "calcPrimes({0}) = {1}")
    @MethodSource("argumentProvider")
    public void testCalcPrimesBelow(final int n, final List<Integer> expected) throws Exception
    {
        final List<Integer> result = Ex04_PrimeNumber.calcPrimesUpTo(n);

        assertEquals(expected, result);
    }

    // wir erwarten eine Liste von Werten, dass lässt sich kaum sinnvoll mit
    // CsvSource usw. ausdrücken => Stream<Arguments>
    // Variante, wenn die Map umfangreicher ist
    static Stream<Arguments> argumentProvider()
    {
        return Stream.of(Arguments.of(2, List.of(2)),
                         Arguments.of(3, List.of(2, 3)),
                         Arguments.of(10, List.of(2, 3, 5, 7)),
                         Arguments.of(15, List.of(2, 3, 5, 7, 11, 13)),
                         Arguments.of(25, List.of(2, 3, 5, 7, 11, 13,
                                                  17, 19, 23)),
                         Arguments.of(50, List.of(2, 3, 5, 7, 11, 13,
                                                  17, 19, 23, 29, 31,
                                                  37, 41, 43, 47)));
    }
}
