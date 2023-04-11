package ch06_dateprocessing.intro;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class NewApiDurationCalculationExample
{
    public static void main(String[] args) throws ParseException
    {
        // Unterschied 1 Stunde, 10 Minute und 20 Sekunden
        final String startTimeAsString = "10:10:10";
        final String endTimeAsString  = "11:20:30";

        // Umwandlung in LocalTime-Objekte
        final LocalTime startTime = LocalTime.parse(startTimeAsString);
        final LocalTime endTime = LocalTime.parse(endTimeAsString);

        // Berechne Differenz als Duration und in Sekunden
        final Duration duration = Duration.between(startTime, endTime);
        final long durationInSecs = duration.getSeconds();

        System.out.println("duration = " + duration + " in secs = " + durationInSecs);

        // Umwandlung in LocalTime und Ausgabe
        final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        final LocalTime durationAsLocalTime = LocalTime.ofSecondOfDay(durationInSecs);
        System.out.println("durationInHHmmss = " + dateFormat.format(durationAsLocalTime));
    }
}