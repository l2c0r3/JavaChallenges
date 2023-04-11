package ch04_strings.intro;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class CharacterConvertExample
{
    public static void main(final String[] args)
    {
        System.out.println(convertToDecimal("0"));
        System.out.println(convertToDecimal("7"));
        System.out.println(convertToDecimal("A"));
        System.out.println(convertToDecimal("a"));

        System.out.println(convertToDecimal("AF7"));

        showSpecialCases();
    }

    static int convertToDecimal(final String hexDigits)
    {
        int valueOldStyle = 0;
        int valueNewStyle = 0;

        for (int i = 0; i < hexDigits.length(); i++)
        {
            char currentChar = hexDigits.charAt(i);

            // ALT und umständlich
            int digitValueOld = hexDigitToDecimal(currentChar);
            valueOldStyle = valueOldStyle * 16 + digitValueOld;

            // NEU und kurz und knackig
            int digitValue = Character.getNumericValue(currentChar);
            valueNewStyle = valueNewStyle * 16 + digitValue;
        }

        System.out.println("old: " + valueOldStyle);

        return valueNewStyle;
    }

    private static int hexDigitToDecimal(char currentChar)
    {
        int digitValueOld = 0;
        if (Character.isDigit(currentChar))
        {
            digitValueOld = currentChar - '0';
        }
        else
        {
            // A ... F
            digitValueOld = currentChar - 'A' + 10;
        }
        return digitValueOld;
    }

    static void showSpecialCases()
    {
        System.out.println("\u0669");
        System.out.println(Character.isDigit('\u0669'));
        System.out.println(Character.getNumericValue('\u0669'));
        System.out.println(hexDigitToDecimal('\u0669'));
    }
}
