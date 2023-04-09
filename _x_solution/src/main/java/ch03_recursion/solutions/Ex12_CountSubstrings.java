package ch03_recursion.solutions;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex12_CountSubstrings
{
    private Ex12_CountSubstrings()
    {
    }

    static int countSubstring(final String input, final String valueToFind)
    {
        if (input.length() < valueToFind.length())
            return 0;

        final int count;
        final String remaining;

        if (input.startsWith(valueToFind))
        {
            remaining = input.substring(valueToFind.length());
            count = 1;
        }
        else
        {
            // entferne erstes Zeichen und suche erneut
            remaining = input.substring(1);
            count = 0;
        }

        return countSubstring(remaining, valueToFind) + count;
    }

    static int countSubstringOpt(final String input, final String valueToFind)
    {
        return countSubstringOpt(input, valueToFind, 0);
    }

    static int countSubstringOpt(final String input, final String valueToFind, int left)
    {
        if (input.length() - left < valueToFind.length())
            return 0;

        int count = 0;
        if (input.startsWith(valueToFind, left))
        {
            left += valueToFind.length();
            count = 1;
        }
        else
        {
            // überspringe Zeichen und suche erneut
            left++;
        }

        return countSubstringOpt(input, valueToFind, left) + count;
    }

    static int countSubstringV2(final String input, final String valueToFind)
    {
        if (input.length() < valueToFind.length())
            return 0;

        int count = 0;
        if (input.startsWith(valueToFind))
            count = 1;

        // entfene erstes Zichen und suche erneut
        final String remaining = input.substring(1);

        return countSubstringV2(remaining, valueToFind) + count;
    }

    static int countSubstringsShort(final String input, final String valueToFind)
    {
        return input.length() < valueToFind.length()
                        ? 0
                        : (input.startsWith(valueToFind) ? 1 : 0)
                        + countSubstringsShort(input.substring(1), valueToFind);
    }

}
