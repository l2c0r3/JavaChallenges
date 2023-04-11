package ch03_recursion.intro;

import java.util.Arrays;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class PalindromeChecks
{
    public static void main(final String[] args)
    {
        final int[] inputsOK = { 1, 2, 3, 2, 1 };
        final boolean isPalindrome1 = isPalindromeSimplRec(inputsOK);
        final boolean isPalindrome1a = isPalindromeRec(inputsOK);
        final boolean isPalindrome1b = isPalindromeIter(inputsOK);
        System.out.println(isPalindrome1 + "/ " + isPalindrome1a + "/ " + isPalindrome1b);

        final int[] inputsWrong = { 1, 2, 3, 4 };
        final boolean isPalindrome2 = isPalindromeSimplRec(inputsWrong);
        final boolean isPalindrome2a = isPalindromeRec(inputsWrong);
        final boolean isPalindrome2b = isPalindromeIter(inputsWrong);
        System.out.println(isPalindrome2  + "/ " + isPalindrome2a  + "/ " + isPalindrome2b);
    }

    // Algorithmus: Wenn das Array die Länge 0 oder 1 hat, dann ist es ein Palidrom,
    // bei Länge 2 und grösser, wird jeweils das linke und recht äussere Element geprüft und
    // danach dann auf dem verbliebenden Teilstück weitergemacht.
    private static boolean isPalindromeSimplRec(final int[] values)
    {
        if (values.length <= 1)
            return true;

        // Prüfe links == rechts
        final int left = 0;
        final int right = values.length-1;
        if (values[left] == values[right])
        {
            // rekursiver Abstieg, Achtung: copyOfRange, exklusive Ende
            final int[] reminder = Arrays.copyOfRange(values, left + 1, right);
            return isPalindromeRec(reminder);
        }

        return false;
    }

    private static boolean isPalindromeRec(final int[] values)
    {
        return isPalindromeRec(values, 0, values.length-1);
    }

    private static boolean isPalindromeRec(final int[] values, final int left, final int right)
    {
        if (left >= right)
            return true;

        if (values[left] == values[right])
        {
            // rekursiver Abstieg
            return isPalindromeRec(values, left + 1, right - 1);
        }

        return false;
    }

    private static boolean isPalindromeIter(final int[] values)
    {
        int left = 0;
        int right = values.length - 1;
        boolean sameValue = true;

        while (left < right && sameValue)
        {
            sameValue = values[left] == values[right];

            left++;
            right--;
        }

        return sameValue;
    }

    static boolean isPalindromeIterativeCompact(final int[] values)
    {
        int left = 0;
        int right = values.length - 1;

        while (left < right && values[left] == values[right])
        {
            left++;
            right--;
        }
        // left >= right || values[left] != values[right]
        return left >= right;
    }
}
