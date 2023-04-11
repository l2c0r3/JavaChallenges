package ch02_math.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
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
public class Ex12_BefreundeteZahlenTest
{
    @ParameterizedTest(name = "calcFriends({0}) = {1}")
    @MethodSource("upperBoundAndExpectedFriends")
    public void calcFriends(int maxValue, Map<Integer, Integer>  expected)
    {
        Map<Integer, Integer> result = Ex12_BefreundeteZahlen.calcFriends(maxValue);

        assertEquals(expected, result);
    }

    static Stream<Arguments> upperBoundAndExpectedFriends()
    {
        return Stream.of(Arguments.of(250, Map.of(220, 284)),
                         Arguments.of(300, Map.of(220, 284,
                                                  284, 220)),
                         Arguments.of(2_000, Map.of(220, 284,
                                                    284, 220,
                                                    1184, 1210,
                                                    1210,1184)));
    }
}
