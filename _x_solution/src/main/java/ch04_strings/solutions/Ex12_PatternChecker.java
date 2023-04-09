package ch04_strings.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex12_PatternChecker
{
    private Ex12_PatternChecker()
    {
    }

    static boolean matchesPattern(final String pattern, final String input)
    {
        // Vorbereitung
        final int patternLength = pattern.length();
        final String[] values = input.split(" ");
        final int valuesLength = values.length;

        if (valuesLength != patternLength || values.length == 1 && values[0].isEmpty())
            return false;

        final Map<Character, String> placeholderToValueMap = new HashMap<>();

        // Durchlaufe alle Zeichen des Musters
        for (int i = 0; i < pattern.length(); i++)
        {
            final char patternChar = pattern.charAt(i);
            final String value = values[i];

            // füge hinzu, sofern noch nicht da
            placeholderToValueMap.putIfAbsent(patternChar, value);

            // stimmt gespeicherter Wert mit aktueller Zeichenfolge überein?
            final String assignedValue = placeholderToValueMap.get(patternChar);
            if (!assignedValue.equals(value))
                return false;
        }
        return true;
    }

    static boolean inputMatchesPatternNoDuplicateValuesForKeys(final String pattern, final String input)
    {
        // Vorbereitung
        final int patternLength = pattern.length();
        final String[] values = input.split(" ");
        final int valuesLength = values.length;

        if (valuesLength != patternLength || values.length == 1 && values[0].isEmpty())
            return false;

        final Map<Character, String> placeholderToValueMap = new HashMap<>();

        // Durchlaufe alle Zeichen des Musters
        for (int i = 0; i < pattern.length(); i++)
        {
            final char patternChar = pattern.charAt(i);
            final String value = values[i];

            // füge hinzu, sofern noch nicht da
            placeholderToValueMap.putIfAbsent(patternChar, value);

            // stimmt gespeicherter Wert mit aktueller Zeichenfolge überein?
            final String assignedValue = placeholderToValueMap.get(patternChar);
            if (!assignedValue.equals(value))
                return false;

            // Teste auf Eindeuitgkeit
            if (placeholderToValueMap.values().stream().filter(str -> str.equals(value)).count() > 1)
                return false;
        }
        return true;
    }
}
