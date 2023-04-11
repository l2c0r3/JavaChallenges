package ch06_dateprocessing.intro;

import java.time.DayOfWeek;
import java.time.Month;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class MonthAndDayOfWeekExample
{
    public static void main(final String[] args)
    {
        final DayOfWeek sunday = DayOfWeek.SUNDAY;
        final Month february = Month.FEBRUARY;

        final DayOfWeek friday = sunday.plus(5);
        final Month march = february.plus(13);

        System.out.println(friday);   // FRIDAY
        System.out.println(march); // MARCH
    }
}