package ch08_recursion_advanced.solutions;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex01_TowerOfHanoi
{
    private Ex01_TowerOfHanoi()
    {
    }

    public static void main(final String[] args)
    {
        solveTowerOfHanoi(1);
        solveTowerOfHanoi(2);
        solveTowerOfHanoi(3);

    }

    private static void solveTowerOfHanoi(final int n)
    {
        System.out.println("Tower Of Hanoi " + n);
        moveTower(n, 'A', 'B', 'C');
    }

    private static void moveTower(final int n, final char source, final char helper, final char destination)
    {
        if (n == 1)
        {
            System.out.println(source + " -> " + destination);
        }
        else
        {
            // bewege um ein reduierten von Quelle auf Hilfstab, (Ziel wird so zum neuen Hilfsstab)
            moveTower(n-1, source, destination, helper);

            // bewege die grösste Scheibe
            moveTower(1, source, helper, destination);

            // bewege um ein reduzierten Turm von Hilfsstab aud Ziel
            moveTower(n-1, helper, source, destination);
        }
    }
}
