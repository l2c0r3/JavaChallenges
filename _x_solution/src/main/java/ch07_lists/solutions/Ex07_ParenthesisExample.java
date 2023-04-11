package ch07_lists.solutions;

import java.util.Optional;
import java.util.Stack;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex07_ParenthesisExample
{
    private Ex07_ParenthesisExample()
    {
    }

    static boolean checkParentheses(final String input)
    {
        // uneven/odd input length can't be a valid combination of parenthensis
        if (input.length() % 2 != 0)
            return false;

        final Stack<Character> openingParentheses = new Stack<>();

        for (int i = 0; i < input.length(); i++)
        {
            final char currentChar = input.charAt(i);
            if (isOpeningParenthesis(currentChar))
            {
                openingParentheses.push(currentChar);
            }
            else if (isClosingParenthesis(currentChar))
            {
                // im JUnit-Kurs weglassen und durch Testfälle finden lassen
                if (openingParentheses.isEmpty())
                {
                    // closing before opening
                    return false;
                }

                final char lastOpeningParens = openingParentheses.pop();

                if (!isMatchingParenthesisPair(lastOpeningParens, currentChar))
                {
                    // mismatch in parenthesis
                    return false;
                }
            }
            else
            {
                // invalid char
                return false;
            }
        }

        return openingParentheses.isEmpty();
    }

    // Umbau mit Enum
    enum CheckResult {
        OK, ODD_LENGTH, CLOSING_BEFORE_OPENING, MISMATCHING, INVALID_CHAR, REMAINING_OPENING
    };

    static CheckResult checkParenthesesV2(final String input)
    {
        if (input.length() % 2 != 0)
            return CheckResult.ODD_LENGTH;

        final Stack<Character> openingParens = new Stack<>();

        for (int i = 0; i < input.length(); i++)
        {
            final char currentChar = input.charAt(i);
            if (isOpeningParenthesis(currentChar))
            {
                openingParens.push(currentChar);
            }
            else if (isClosingParenthesis(currentChar))
            {
                if (openingParens.isEmpty())
                {
                    return CheckResult.CLOSING_BEFORE_OPENING;
                }

                char lastOpeningParens = openingParens.pop();

                if (!isMatchingParenthesisPair(lastOpeningParens, currentChar))
                {
                    return CheckResult.MISMATCHING;
                }
            }
            else
            {
                return CheckResult.INVALID_CHAR;
            }
        }

        if (openingParens.isEmpty())
            return CheckResult.OK;

        return CheckResult.REMAINING_OPENING;
    }

    enum CheckResultV2 {
        OK, ODD_LENGTH, CLOSING_BEFORE_OPENING, MISMATCHING, INVALID_CHAR, REMAINING_OPENING;

        private String additionalInfo;

        // Trick
        public CheckResultV2 withInfo(final String info)
        {
            additionalInfo = info;
            return this;
        }

        public Optional<String> getAddtionalInfo()
        {
            return Optional.ofNullable(additionalInfo);
        }

        @Override
        public String toString()
        {
            if (additionalInfo != null)
                return super.toString() + " / Info: " + additionalInfo;

            return super.toString();
        }
    };

    // Algorithmus: Durchlaufe den String von vorne nach hinten:
    // Ist das aktuelle Zeichen eine öffenende Klammer, so
    // speichere dieses auf einem Stack. Lese weiter.
    // Ist es eine schliessende Klammer, so hole das oberste
    // Element vom Stack und vergleiche es
    static CheckResultV2 checkParenthesesSpecial(final String input)
    {
        // uneven/odd input length can't be a valid combination of parenthensis
        if (input.length() % 2 != 0)
            return CheckResultV2.ODD_LENGTH.withInfo("" + input.length());

        final Stack<Character> openingParens = new Stack<>();

        for (int i = 0; i < input.length(); i++)
        {
            final char currentChar = input.charAt(i);
            if (isOpeningParenthesis(currentChar))
            {
                openingParens.push(currentChar);
            }
            else if (isClosingParenthesis(currentChar))
            {
                // im JUnit-Kurs weglassen und durch Testfälle finden lassen
                if (openingParens.isEmpty())
                {
                    // closing before opening
                    return CheckResultV2.CLOSING_BEFORE_OPENING.withInfo("" + currentChar);
                }

                char lastOpeningParens = openingParens.pop();

                if (!isMatchingParenthesisPair(lastOpeningParens, currentChar))
                {
                    // mismatch in parenthesis
                    return CheckResultV2.MISMATCHING
                                    .withInfo("" + lastOpeningParens + " <> " + currentChar);
                }
            }
            else
            {
                // invalid char
                return CheckResultV2.INVALID_CHAR.withInfo("" + currentChar);
            }
        }

        if (openingParens.isEmpty())
            return CheckResultV2.OK;

        return CheckResultV2.REMAINING_OPENING;
    }

    // Helpers
    static boolean isOpeningParenthesis(char ch)
    {
        return ch == '(' || ch == '[' || ch == '{';
    }

    static boolean isClosingParenthesis(char ch)
    {
        return ch == ')' || ch == ']' || ch == '}';
    }

    static boolean isMatchingParenthesisPair(char opening, char closing)
    {
        return opening == '(' && closing == ')' || opening == '[' && closing == ']'
                        || opening == '{' && closing == '}';
    }
}
