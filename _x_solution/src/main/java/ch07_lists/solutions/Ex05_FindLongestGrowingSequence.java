package ch07_lists.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex05_FindLongestGrowingSequence
{
    private Ex05_FindLongestGrowingSequence()
    {
    }

    static List<Integer> findLongestGrowingSequence(final List<Integer> values)
    {
        List<Integer> longestSubsequence = List.of();
        List<Integer> currentSubsequence = new ArrayList<>();

        int lastValue = Integer.MIN_VALUE;
        // durchlaufe Zeichenweise
        for (final int currentValue : values)
        {
            if (currentValue >= lastValue)
            {
                lastValue = currentValue;
                currentSubsequence.add(currentValue);
            }
            else
            {
                // Ende dieser Sequenze, starte neue Sequenz
                // prüfe die Länge, ggf. neue längste Sequnez
                // > findet erste, >= letztes Vorkommen
                if (currentSubsequence.size() >= longestSubsequence.size())
                {
                    longestSubsequence = currentSubsequence;
                }
                currentSubsequence = new ArrayList<>();
                lastValue = currentValue;
                currentSubsequence.add(currentValue);
            }
        }

        // möglicher Bug: kann man schnell vergessen, ist aber wichtig, weil sonst die letzte Sequenz ggf. nicht betrachtet wird
        if (currentSubsequence.size() >= longestSubsequence.size())
        {
            longestSubsequence = currentSubsequence;
        }

        return longestSubsequence;
    }

    static List<Integer> findLongestGrowingSequenceOpt(final List<Integer> values)
    {
        List<Integer> longestSubsequence = List.of();
        List<Integer> currentSubsequence = new ArrayList<>();

        int lastValue = Integer.MIN_VALUE;
        // durchlaufe Zeichenweise
        for (int i = 0; i < values.size(); i++)
        {
            final int currentValue = values.get(i);
            if (currentValue < lastValue)
            {
                // Ende dieser Sequenze, starte neue Sequenz
                // prüfe die Länge, ggf. neue längste Sequnez
                // > findet erste, >= letztes Vorkommen
                if (currentSubsequence.size() >= longestSubsequence.size())
                {
                    longestSubsequence = currentSubsequence;
                }
                currentSubsequence = new ArrayList<>();
            }

            lastValue = currentValue;
            currentSubsequence.add(currentValue);
        }

        // kann man schnell vergessen, ist aber wichtig, weil sonst di letzte Sequenz ggf. nicht betrachtet wird
        if (currentSubsequence.size() >= longestSubsequence.size())
        {
            longestSubsequence = currentSubsequence;
        }

        return longestSubsequence;
    }


    static record StartEndPair(int start, int end)
    {
        int length()
        {
            return end - start;
        }
    }

    static List<Integer> findLongestGrowingSequenceIndexBased(final List<Integer> values)
    {
        if (values.isEmpty())
            return values;

        StartEndPair longest = new StartEndPair(0, 0);
        int startCurrent = 0;
        int endCurrent;

        for (endCurrent = 1; endCurrent < values.size(); endCurrent++)
        {
            if (values.get(endCurrent) < values.get(endCurrent - 1))
            {
                if (endCurrent - startCurrent > longest.length())
                {
                    longest = new StartEndPair(startCurrent, endCurrent);
                }
                startCurrent = endCurrent;
            }
        }

        if (endCurrent - startCurrent > longest.length())
        {
            longest = new StartEndPair(startCurrent, endCurrent);
        }

        return values.subList(longest.start, longest.end);
    }
}
