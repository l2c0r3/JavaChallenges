package ch06_dateprocessing.solutions;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex10_FirstDayOfQuarterOptimized implements TemporalAdjuster
{
    @Override
    public Temporal adjustInto(final Temporal temporal)
    {
        return LocalDate.from(temporal).with(IsoFields.DAY_OF_QUARTER, 1);
    }
}