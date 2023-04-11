package ch06_dateprocessing.solutions;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex01_LeapYear
{
    private Ex01_LeapYear()
    {
    }

    static boolean isLeap(final int year)
    {
        final boolean everyFourthYear = year % 4 == 0;
        final boolean isSecular = year % 100 == 0;
        final boolean isSecularSpecial = year % 400 == 0;

        return everyFourthYear && (!isSecular || isSecularSpecial);
    }
}
