package ch03_recursion.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex11_Permutations
{
    private Ex11_Permutations()
    {
    }

    static Set<String> calcPermutations(final String input)
    {
        // rekursiver Abbruch
        if (input.isEmpty() || input.length() == 1)
            return Set.of(input);

        final Set<String> combinations = new HashSet<>();
        for (int i = 0; i < input.length(); i++)
        {
            // Extrahiere i-tes Zeichen als neues erstes Zeichen
            final String newFirst = "" + input.charAt(i);

            // Rest ohne i-tes Zeichen
            final String newInput = input.substring(0, i) + input.substring(i + 1);

            // rekursiver Abstieg
            final Set<String> permutations = calcPermutations(newInput);

            // Hinzufügen des extrahierten Zeichens zu allen Teillösungen
            for (final String perm : permutations)
            {
                combinations.add(newFirst + perm);
            }
        }
        return combinations;
    }

    static Set<String> calcPermutationsMiniOpt(final String input)
    {
        return calcPermutationsMiniOpt(input, "");
    }

    static Set<String> calcPermutationsMiniOpt(final String remaining, final String prefix)
    {
        if (remaining.length() == 0)
            return Set.of(prefix);

        final Set<String> candidates = new HashSet<>();

        for (int i = 0; i < remaining.length(); i++)
        {
            // erstes Teilstück
            String newPrefix = prefix + remaining.charAt(i);

            // Rest (ohne extrahiertes Zeichen)
            final String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            candidates.addAll(calcPermutationsMiniOpt(newRemaining, newPrefix));
        }

        return candidates;
    }
}
