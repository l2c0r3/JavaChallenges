package ch05_arrays.solutions;

/**
 * Beispielprogramm aus dem Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex04_Rotate_Inplace
{
    private Ex04_Rotate_Inplace()
    {
    }

    static <T> void rotateInplace(final T[][] values)
    {
        final int height = values.length - 1;
        final int width = values[0].length - 1;

        int offset = 0;
        while (offset <= width / 2)
        {
            final int currentWidth = width - offset * 2;
            for (int idx = 0; idx < currentWidth; idx++)
            {
                // top, right, bottom, left
                final int loX = offset + idx;
                final int loY = offset;

                final int roX = width - offset;
                final int roY = offset + idx;

                final int ruX = width - offset - idx;
                final int ruY = height - offset;

                final int luX = offset;
                final int luY = height - offset - idx;

                final T lo = values[loY][loX];
                final T ro = values[roY][roX];
                final T ru = values[ruY][ruX];
                final T lu = values[luY][luX];

                // umkopieren
                values[roY][roX] = lo;
                values[ruY][ruX] = ro;
                values[luY][luX] = ru;
                values[loY][loX] = lu;
            }

            offset++;
        }
    }

    static <T> void rotateInplaceRecursive(final T[][] values)
    {
        rotateInplaceRecursive(values, 0, values.length - 1);
    }

    static <T> void rotateInplaceRecursive(final T[][] values, final int left, final int right)
    {
        if (left >= right)
            return;

        final int rotCount = right - left;
        for (int i = 0; i < rotCount; i++)
        {
            final T lo = values[left + i][left];
            final T ro = values[right][left + i];
            final T ru = values[right - i][right];
            final T lu = values[left][right - i];

            values[left + i][left] = ro;
            values[right][left + i] = ru;
            values[right - i][right] = lu;
            values[left][right - i] = lo;
        }
        rotateInplaceRecursive(values, left + 1, right - 1);
    }

    static <T> void rotateInplaceV2(final T[][] array)
    {
        int sideLength = array.length;
        int start = 0;
        while (sideLength > 0)
        {
            for (int i = 0; i < sideLength - 1; i++)
            {
                rotateElements(array, start, sideLength, i);
            }
            sideLength = sideLength - 2;
            start++;
        }
    }

    static <T> void rotateElements(final T[][] array, final int start, final int len, final int i)
    {
        final int end = start + len - 1;
        final T tmp = array[start][start + i];
        array[start][start + i] = array[end - i][start];
        array[end - i][start] = array[end][end - i];
        array[end][end - i] = array[start + i][end];
        array[start + i][end] = tmp;
    }

}
