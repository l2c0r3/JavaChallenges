package ch10_searching_sorting.solutions;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex08_RotatedSearch
{
    private Ex08_RotatedSearch()
    {
    }

    static int findFlankPos(final int[] values)
    {
        return findFlankPosHelper(values, 0, values.length - 1);
    }

    static int findFlankPosHelper(final int[] values, final int left, final int right)
    {
        final int midPos = left + (right - left) / 2;
        final int midValue = values[midPos];

        // Spezialfall keine Rotation
        if (values[left] < values[right])
            return 0;

        // Fall A: Wert links davon ist größer, dann haben wir Flankenwechsel
        int prevIndex = midPos - 1;
        if (prevIndex < 0)
            prevIndex = values.length - 1;

        if (values[prevIndex] > midValue)
            return midPos;

        if (values[left] > midValue)
        {
            // Fall B: Flankenwechsel muss links liegen, da erster Wert
            // größer als in der Mitte
            return findFlankPosHelper(values, left, midPos + 1);
        }
        if (values[right] < midValue)
        {
            // Fall C: Flankenwechsel muss rechts liegen, da letzter Wert
            // kleiner als in der Mitte
            return findFlankPosHelper(values, midPos + 1, right);
        }

        throw new IllegalStateException("should never reach here!");
    }

    static int minValue(final int[] values)
    {
        final int flankpos = findFlankPos(values);
        return values[flankpos];
    }

    static int maxValue(final int[] values)
    {
        int flankpos = findFlankPos(values);
        // kann nur bei Rotation 0 auftreten
        if (flankpos == 0)
            flankpos = values.length;
        return values[flankpos - 1];
    }

    static int binarySearchRotated(final int[] values, final int searchFor)
    {
        final int flankpos = findFlankPos(values);

        return binarySearchRotatedHelper(values, searchFor, flankpos, flankpos - 1 + values.length);
    }

    static int binarySearchRotatedHelper(final int[] values, final int searchFor, final int start, final int end)
    {
        if (start > end)
            return -1;

        final int midPos = start + (end - start) / 2;
        final int midValue = values[midPos % values.length];

        if (midValue == searchFor)
            return midPos % values.length;

        if (searchFor < midValue)
        {
            return binarySearchRotatedHelper(values, searchFor, start, midPos - 1);
        }
        if (searchFor > midValue)
        {
            return binarySearchRotatedHelper(values, searchFor, midPos + 1, end);
        }
        throw new IllegalStateException("should never reach here!");
    }
}
