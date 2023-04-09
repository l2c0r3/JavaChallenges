package ch06_dateprocessing.solutions;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
public class Ex11_NthWeekdayAdjuster implements TemporalAdjuster
{
    private final DayOfWeek dayToAdjust;
    private final int       count;

    public Ex11_NthWeekdayAdjuster(final DayOfWeek dayToAdjust, final int count)
    {
        this.dayToAdjust = dayToAdjust;
        this.count = count;
    }

    @Override
    public Temporal adjustInto(final Temporal input)
    {
        final LocalDate startday = LocalDate.from(input);

        LocalDate adjustedDay =
                        startday.with(TemporalAdjusters.firstInMonth(dayToAdjust));

        // Achtung: Bei 1 starten, weil menschliche Denkweise nicht 0-basiert!
        for (int i = 1; i < count; i++)
        {
            adjustedDay = adjustedDay.with(TemporalAdjusters.next(dayToAdjust));
        }

        return input.with(adjustedDay);
    }
}
