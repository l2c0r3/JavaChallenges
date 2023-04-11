package ch05_arrays.solutions;

import java.util.Arrays;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex08_AddOneToAnArrayOfNumbers {

    private Ex08_AddOneToAnArrayOfNumbers()
    {
    }

    static int[] addOne(final int[] values)
    {
        if (values.length == 0)
            throw new IllegalArgumentException("must pass a valid non empty array");

        final int[] result = Arrays.copyOf(values, values.length);

        // Algo: Laufe von hinten nach vorne und addiere eins,
        // prüfe auf Overflow und propagiere diesen
        int overflow = 1;
        int pos = values.length - 1;
        while (overflow == 1 && pos >= 0)
        {
            int currValue = result[pos];
            currValue += overflow;
            result[pos] = currValue % 10;

            if (currValue >= 10)
                overflow = 1;
            else
                overflow = 0;

            pos--;
        }

        return handleOverflowAtTop(result, overflow);
    }

    static int[] handleOverflowAtTop(final int[] result, final int overflow)
    {
        if (overflow == 1)
        {
            // neues Array und vorne eine 1
            final int[] newValues = new int[result.length + 1];
            newValues[0] = 1;
            for (int i = 0; i < result.length; i++)
                newValues[1 + i] = result[i];

            return newValues;
        }
        else
        {
            return result;
        }
    }
}
