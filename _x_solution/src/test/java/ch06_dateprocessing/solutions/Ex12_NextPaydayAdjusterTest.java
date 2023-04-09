package ch06_dateprocessing.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex12_NextPaydayAdjusterTest
{
    @ParameterizedTest(name = "adjustToPayday({0}) => {1}, {2}")
    @CsvSource(value = { "2019-07-21; 2019-07-25; normale Anpassung",
                         "2019-06-27; 2019-07-25; normale Anpassung " + "auf nächsten Monat",
                         "2019-08-21; 2019-08-23; Freitag, falls 25. " + "am Wochenende",
                         "2019-12-06; 2019-12-16; Dezember: Mitte Monat " + "und Montag nach Wochenende",
                         "2019-12-23; 2020-01-24; nächster Monat und Freitag, " + "falls 25. am Wochenende" }, delimiterString = ";")
    public void adjustInto(LocalDate startDay, LocalDate expected, String info)
    {
        final TemporalAdjuster paydayAdjuster = new Ex12_NextPaydayAdjuster();

        final Temporal result = paydayAdjuster.adjustInto(startDay);

        assertEquals(expected, result);
    }
}
