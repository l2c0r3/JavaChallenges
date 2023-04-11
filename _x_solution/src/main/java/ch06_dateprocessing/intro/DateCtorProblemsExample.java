package ch06_dateprocessing.intro;

import java.util.Date;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class DateCtorProblemsExample
{
    public static void main(final String[] args)
    {
        // Geburtstag des Autors: 7.2.1971
        final int year = 1971;
        final int month = 2;
        final int day = 7;

        System.out.println(new Date(year, month, day));
        System.out.println(new Date(year - 1900, month - 1, day));
    }
}