package ch02_math.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex11_MaxChangeCalculator
{
    private Ex11_MaxChangeCalculator()
    {
    }

    static int calcMaxPossibleChange(final List<Integer> values)
    {
        final List<Integer> sortedNumberx = new ArrayList<>(values);
        sortedNumberx.sort(Integer::compareTo);

        int maxPossibleChange = 0;

        for (int currentValue : sortedNumberx)
        {
            if (currentValue > maxPossibleChange + 1)
                break;

            maxPossibleChange += currentValue;
        }

        return maxPossibleChange;
    }
}
