package ch04_strings.solutions;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex06_DuplicateCharsRemoval
{
    private Ex06_DuplicateCharsRemoval()
    {
    }

    static String removeDuplicates(final String input)
    {
        var result = new StringBuilder();
        final Set<Character> alreadySeen = new HashSet<>();

        for (int i = 0; i < input.length(); i++)
        {
            final char currentChar = input.charAt(i);
            if (!alreadySeen.contains(currentChar))
            {
                alreadySeen.add(currentChar);

                result.append(currentChar);
            }
        }

        return result.toString();
    }

    static String removeDuplicatesImproved(final String input)
    {
        final IntStream chars = input.chars();
        return chars.distinct().mapToObj(i -> (char) i + "").collect(Collectors.joining());
    }
}
