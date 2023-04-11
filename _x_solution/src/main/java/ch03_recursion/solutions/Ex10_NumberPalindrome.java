package ch03_recursion.solutions;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex10_NumberPalindrome
{
    private Ex10_NumberPalindrome()
    {
    }

    public static boolean isNumberPalindrome(final int number)
    {
        if (number < 10)
            return true;

        final int factor = calcPowOfTen(number);
        final int divisor = (int) Math.pow(10, factor);

        if (number < divisor * 10)
        {
            final int leftNumber = number / divisor;
            final int rightNumber = number % 10;

            final int remainingNumber = number / 10 % (divisor / 10);
            return leftNumber == rightNumber && isNumberPalindrome(remainingNumber);
        }

        return false;
    }

    private static int calcPowOfTen(final int number)
    {
        return countDigits(number) - 1;
    }

    private static int countDigits(int number)
    {
        int count = 0;
        while (number > 0)
        {
            number = number / 10;
            count++;
        }

        return count;
    }

    // Idee: Separiere jeweils die letzte Ziffer, teile dann durch 10 und rufe die
    // Methode mit den neuern Werten auf. Berechne zuvor noch aus dem aktuellen Wert und
    // der letzten Ziffer den neuen Wert, indem der aktuelle Wert mit 10 multipliziert und die
    // letzte Ziffer angehängt wird. Ist es ein Palindrom, dann gilt der Originalwert entspricht
    // dem berechnetene Wert. Der rekursive Abbruch erfolgt, wenn keine Ziffer mehr existiert.
    public static boolean isNumberPalindromeRec(final int number)
    {
        return isNumberPalindromeRec(number, 0, number);
    }

    static boolean isNumberPalindromeRec(final int origNumber, final int currentValue, final int remainingValue)
    {
        // rekursiver Abbruch
        if (origNumber == currentValue)
            return true;

        // rekursiver Abbruch
        if (remainingValue < 1)
            return false;

        final int lastDigit = remainingValue % 10;
        final int newRemaining = remainingValue / 10;
        final int newCurrent = currentValue * 10 + lastDigit;

        System.out.println(String.format("lastDigit: %,4d, " +
                        "newCurrent: %,4d, newRemaining: %,4d",
                        lastDigit, newCurrent, newRemaining));

        // rekursiver Abstieg
        return isNumberPalindromeRec(origNumber, newCurrent, newRemaining);
    }
}