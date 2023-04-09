package ch06_dateprocessing.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class DateUtils
{
    public static void printCalendar(final Month month, final int year)
    {
        System.out.println("Mo Di Mi Do Fr Sa So ");

        final LocalDate cur = LocalDate.of(year, month, 1);
        final DayOfWeek firstInMonth = cur.getDayOfWeek();

        skipTillFirstDayOfMonth(firstInMonth);

        DayOfWeek currentWeekDay = firstInMonth;
        final int lengthOfMonth = month.length(Year.of(year).isLeap());
        for (int i = 1; i <= lengthOfMonth; i++)
        {
            System.out.print(String.format("%02d", i) + " ");
            if (currentWeekDay == DayOfWeek.SUNDAY)
                System.out.println();

            currentWeekDay = nextWeekDay(currentWeekDay);
        }

        fillFromMonthEndToSunday(currentWeekDay);

        // letzter Tag nicht Sonntag, dann Umbruch
        if (currentWeekDay != DayOfWeek.MONDAY)
            System.out.println();
    }

    private static void skipTillFirstDayOfMonth(final DayOfWeek firstInMonth)
    {
        DayOfWeek currentWeekDay = DayOfWeek.MONDAY;
        while (currentWeekDay != firstInMonth)
        {
            System.out.print(".. ");
            currentWeekDay = nextWeekDay(currentWeekDay);
        }
    }

    private static void fillFromMonthEndToSunday(final DayOfWeek currentWeekDay)
    {
        DayOfWeek nextWeekDay = currentWeekDay;
        while (nextWeekDay != DayOfWeek.MONDAY)
        {
            System.out.print("-- ");
            nextWeekDay = nextWeekDay(nextWeekDay);
        }
    }

    private static DayOfWeek nextWeekDay(final DayOfWeek currentWeekDay)
    {
        return currentWeekDay.plus(1);
    }

    public static class FirstDayOfQuarter implements TemporalAdjuster
    {
        @Override
        public Temporal adjustInto(final Temporal temporal)
        {
            return LocalDate.from(temporal).with(IsoFields.DAY_OF_QUARTER, 1);
        }
    }

    public static class NthWeekdayAdjuster implements TemporalAdjuster
    {
        private final DayOfWeek dayToAdjust;
        private final int       count;

        public NthWeekdayAdjuster(final DayOfWeek dayToAdjust, final int count)
        {
            this.dayToAdjust = dayToAdjust;
            this.count = count;
        }

        @Override
        public Temporal adjustInto(final Temporal input)
        {
            final LocalDate startday = LocalDate.from(input);

            LocalDate adjustedDay = startday.with(TemporalAdjusters.firstInMonth(dayToAdjust));

            // Achtung: Bei 1 starten, weil menschliche Denkweise nicht 0-basiert!
            for (int i = 1; i < count; i++)
            {
                adjustedDay = adjustedDay.with(TemporalAdjusters.next(dayToAdjust));
            }

            return input.with(adjustedDay);
        }
    }
}
