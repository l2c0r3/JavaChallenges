package ch02_math.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex10_SpecialNumbers
{
    private Ex10_SpecialNumbers()
    {
    }

    static List<Integer> calcArmstrongNumbers()
    {
        final List<Integer> results = new ArrayList<>();

        for (int x = 1; x < 10; x++)
        {
            for (int y = 1; y < 10; y++)
            {
                for (int z = 1; z < 10; z++)
                {
                    final int numericValue = x * 100 + y * 10 + z;
                    final int cubicValue = (int) (Math.pow(x, 3) + Math.pow(y, 3) + Math.pow(z, 3));

                    if (numericValue == cubicValue)
                    {
                        results.add(numericValue);
                    }
                }
            }
        }

        return results;
    }

    // Bonus finde eine gernische Variante mit Lambdas ...
    // Erkenne den Teil mit den Varianzen => Welches FunctionalInterface nimmst du?
    // Passt ein Prädikat? oder doch eine selbstdefinierte "Function"
    static List<Integer> calcNumbers(final CubicFunction func)
    {
        final List<Integer> results = new ArrayList<>();

        for (int x = 1; x < 10; x++)
        {
            for (int y = 1; y < 10; y++)
            {
                for (int z = 1; z < 10; z++)
                {
                    final int numericValue = x * 100 + y * 10 + z;
                    final int cubicValue = func.calc(x, y, z);

                    if (numericValue == cubicValue)
                    {
                        results.add(numericValue);
                    }
                }
            }
        }

        return results;
    }

    @FunctionalInterface
    interface CubicFunction
    {
        int calc(int x, int y, int z);
    }
}
