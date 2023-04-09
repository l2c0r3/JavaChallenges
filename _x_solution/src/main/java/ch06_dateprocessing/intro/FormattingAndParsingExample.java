package ch06_dateprocessing.intro;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.time.format.FormatStyle.SHORT;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class FormattingAndParsingExample
{
    public static void main(final String[] args)
    {
        // Definition einiger spezieller Formatter
        final DateTimeFormatter ddMMyyyyFormat = ofPattern("dd.MM.yyyy");
        final DateTimeFormatter italian_dMMMMyy = ofPattern("d.MMMM y", Locale.ITALIAN);
        final DateTimeFormatter shortGerman = DateTimeFormatter.ofLocalizedDate(SHORT).withLocale(Locale.GERMAN);

        // Achtung: Die textuellen Teile sind in Hochkomma einzuschließen
        final String customPattern = "'Der 'dd'. Tag im 'MMMM' im Jahr 'yy'.'";
        final DateTimeFormatter customFormat = ofPattern(customPattern);

        System.out.println("Formatting:\n");
        final LocalDate february7th = LocalDate.of(1971, 2, 7);

        System.out.println("ddMMyyyyFormat: " + ddMMyyyyFormat.format(february7th));
        System.out.println("italian_dMMMMy: " + italian_dMMMMyy.format(february7th));
        System.out.println("shortGerman:    " + shortGerman.format(february7th));
        System.out.println("customFormat:   " + customFormat.format(february7th));

        // Parsen von Datumswerten
        System.out.println("\nParsing:\n");

        final LocalDate fromIsoDate = LocalDate.parse("1971-02-07");
        final LocalDate fromddMMyyyyFormat = LocalDate.parse("18.03.2014", ddMMyyyyFormat);
        final LocalDate fromShortGerman = LocalDate.parse("18.03.14", shortGerman);
        final LocalDate fromCustomFormat = LocalDate.parse("Der 31. Tag im Dezember im Jahr 19.", customFormat);

        System.out.println("From ISO Date:       " + fromIsoDate);
        System.out.println("From ddMMyyyyFormat: " + fromddMMyyyyFormat);
        System.out.println("From short german:   " + fromShortGerman);
        System.out.println("From custom format:  " + fromCustomFormat);
    }
}