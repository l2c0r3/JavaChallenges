package ch04_strings.solutions;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex09_SimpleBracesChecker
{
    private Ex09_SimpleBracesChecker()
    {
    }

    static boolean checkBraces(final String input)
    {
        int openingCount = 0;

        for (int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);

            if (ch == '(')
            {
                openingCount++;
            }
            else if (ch == ')')
            {
                openingCount--;
                if (openingCount < 0)
                    return false;
            }
        }

        return openingCount == 0;
    }
}
