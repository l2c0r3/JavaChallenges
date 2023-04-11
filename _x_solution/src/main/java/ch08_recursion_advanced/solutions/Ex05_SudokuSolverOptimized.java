package ch08_recursion_advanced.solutions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex05_SudokuSolverOptimized
{
    private Ex05_SudokuSolverOptimized()
    {
    }

    public static void main(final String[] args) throws Exception
    {
        final int[][] boardExample = new int[9][9];

        boardExample[0] = new int[] { 1, 2, 0, 4, 5, 0, 7, 8, 9 };
        boardExample[1] = new int[] { 0, 5, 6, 7, 0, 9, 0, 2, 3 };
        boardExample[2] = new int[] { 7, 8, 0, 1, 2, 3, 4, 5, 6 };
        boardExample[3] = new int[] { 2, 1, 4, 0, 6, 0, 8, 0, 7 };
        boardExample[4] = new int[] { 3, 6, 0, 8, 9, 7, 2, 1, 4 };
        boardExample[5] = new int[] { 0, 9, 7, 0, 1, 4, 3, 6, 0 };
        boardExample[6] = new int[] { 5, 3, 1, 6, 0, 2, 9, 0, 8 };
        boardExample[7] = new int[] { 6, 0, 2, 9, 7, 8, 5, 3, 1 };
        boardExample[8] = new int[] { 9, 7, 0, 0, 3, 1, 6, 4, 2 };

        solveAndMeasure(boardExample);

        final int[][] board2 = { { 6, 0, 2, 0, 5, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 4, 0, 3, 0 },
                                 { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 4, 3, 0, 0, 0, 8, 0, 0, 0 },
                                 { 0, 1, 0, 0, 0, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 0, 7, 0, 0 },
                                 { 5, 0, 0, 2, 7, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 8, 1 },
                                 { 0, 0, 0, 6, 0, 0, 0, 0, 0 } };

        solveAndMeasure(board2);
    }

    protected static void solveAndMeasure(final int[][] boardExample)
    {
        final long startMs = System.currentTimeMillis();
        System.out.println("Solving: \n");
        printArray(boardExample);

        if (solveSudoku(boardExample))
        {
            final long endMs = System.currentTimeMillis();

            System.out.println("Solved in " + (endMs - startMs) + " ms");
            printArray(boardExample);
        }
    }

    public static boolean solveSudoku(final int[][] board)
    {
        return solveSudoku(board, 0, 0);
    }

    static boolean solveSudoku(final int[][] board, final int startRow, final int startCol)
    {
        int row = startRow;
        int col = startCol;

        // überspringe so lange elder mit Zahlen, bis wir auf ein Leerfeld stossen
        while (row < 9 && board[row][col] != 0)
        {
            col++;
            if (col > 8)
            {
                col = 0;
                row++;
            }
        }

        if (row > 8)
            return true;

        // Find a valid number for the empty cell
        for (int num = 1; num <= 9; num++)
        {
            //board[row][col] = num;

            //if (isValidPosition(board))
            //if (isValidPosition(board, row, col))
            if (isValidPosition(board, row, col, num))
            {
                board[row][col] = num;

                boolean solved = false;
                if (col < 8)
                {
                    // rekursiver Abstieg: nächstes Feld in X-Richtung
                    solved = solveSudoku(board, row, col + 1);
                }
                else
                {
                    // rekursiver Abstieg: nächstes Feld in neuer Zeile
                    solved = solveSudoku(board, row + 1, 0);
                }

                if (!solved)
                {
                    // Backtrack: keine Lösung gefunden
                    board[row][col] = 0;
                }
                else
                {
                    return true;
                }
            }
            else
            {
                board[row][col] = 0;
            }
        }

        return false;
    }

    static boolean isValidPosition(final int[][] board)
    {
        return checkHorizontally(board) && checkVertically(board) && checkBoxes(board);
    }

    // Langsam
    static boolean isValidPosition(final int[][] board, final int row, final int col)
    {
        return checkSingleHorizontally(board, row) && checkSingleVertically(board, col)
                        && checkSingleBox(board, row, col);
    }

    // nur gültige Wege beschreiten, immer prüfen, ob Ziffer ein
    // gültiger Kandidat ist
    private static boolean isValidPosition(final int[][] board,
                                           final int row, final int col, final int num)
    {
        return checkNumNotInColumn(board, col, num) &&
                        checkNumNotInRow(board, row, num) &&
                        checkNumNotInBox(board, row, col, num);
    }

    static boolean checkNumNotInRow(final int[][] board, final int row, final int num)
    {
        for (int col = 0; col < 9; col++)
            if (board[row][col] == num)
                return false;

        return true;
    }

    static boolean checkNumNotInColumn(final int[][] board,
                                       final int col, final int num)
    {
        for (int row = 0; row < 9; row++)
            if (board[row][col] == num)
                return false;

        return true;
    }

    static boolean checkNumNotInBox(final int[][] board,
                                    final int row, final int col, final int num)
    {
        final int adjustedRow = row / 3 * 3;
        final int adjustedCol = col / 3 * 3;

        for (int y = 0; y < 3; y++)
            for (int x = 0; x < 3; x++)
                if (board[adjustedRow + y][adjustedCol + x] == num)
                    return false;

        return true;
    }

    // ----------------------------------

    // check vertically
    public static boolean checkSingleVertically(final int[][] board, final int col)
    {
        // collect all values from one row into a list
        final List<Integer> rowValues = new ArrayList<>();
        for (int row = 0; row < 9; row++)
        {
            rowValues.add(board[row][col]);
        }

        return allDesiredNumbers(rowValues);
    }

    // check horizontally
    static boolean checkSingleHorizontally(final int[][] board, final int row)
    {
        // collect all values from one column into a list
        final List<Integer> columnValues = new ArrayList<>();

        for (int x = 0; x < 9; x++)
        {
            columnValues.add(board[row][x]);
        }

        return allDesiredNumbers(columnValues);
    }

    // check quadrants
    public static boolean checkSingleBox(final int[][] board, final int row, final int col)
    {
        // Werte pro Box
        final List<Integer> boxValues = collectSingleBoxValues(board, row / 3, col / 3);

        return allDesiredNumbers(boxValues);
    }

    private static List<Integer> collectSingleBoxValues(final int[][] board, final int yBox, final int xBox)
    {
        final List<Integer> boxValues = new ArrayList<>();

        // innerhalb der Boxen jeweils 3 x 3 Felder
        for (int y = 0; y < 3; y++)
        {
            for (int x = 0; x < 3; x++)
            {
                // real idx
                final int realY = yBox * 3 + y;
                final int realX = xBox * 3 + x;

                boxValues.add(board[realY][realX]);
            }
        }
        return boxValues;
    }

    // ----------------------------------

    public static boolean checkVertically(final int[][] board)
    {
        for (int x = 0; x < 9; x++)
        {
            // collect all values from one column into a list
            final List<Integer> columnValues = new ArrayList<>();
            for (int row = 0; row < 9; row++)
            {
                columnValues.add(board[row][x]);
            }

            if (!allDesiredNumbers(columnValues))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean checkHorizontally(final int[][] board)
    {
        for (int row = 0; row < 9; row++)
        {
            // collect all values from one row into a list
            final List<Integer> rowValues = new ArrayList<>();
            for (int x = 0; x < 9; x++)
            {
                rowValues.add(board[row][x]);
            }

            if (!allDesiredNumbers(rowValues))
            {
                return false;
            }
        }

        return true;
    }

    // check quadrants
    public static boolean checkBoxes(final int[][] board)
    {
        // 3 x 3 Boxes
        for (int yBox = 0; yBox < 3; yBox++)
        {
            for (int xBox = 0; xBox < 3; xBox++)
            {
                // Werte pro BoX
                final List<Integer> boxValues = collectBoxValues(board, yBox, xBox);

                if (!allDesiredNumbers(boxValues))
                {
                    return false;
                }
            }
        }

        return true;
    }

    static List<Integer> collectBoxValues(final int[][] board, final int yBox, final int xBox)
    {
        final List<Integer> boxValues = new ArrayList<>();

        // innerhalb der Boxen jeweils 3 x 3 Felder
        for (int y = 0; y < 3; y++)
        {
            for (int x = 0; x < 3; x++)
            {
                // real idx
                final int realY = yBox * 3 + y;
                final int realX = xBox * 3 + x;

                boxValues.add(board[realY][realX]);
            }
        }
        return boxValues;
    }

    // Helpers
    static boolean allDesiredNumbers(final Collection<Integer> allCollectedValues)
    {
        final Collection<Integer> relevantValues = new ArrayList<>(allCollectedValues);
        relevantValues.removeIf(val -> val == 0);

        // keine Duplikate?
        final Set<Integer> valuesSet = new TreeSet<>(relevantValues);
        if (relevantValues.size() != valuesSet.size())
            return false;

        // nur 1 bis 9?
        final Set<Integer> oneToNine = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        return oneToNine.containsAll(valuesSet);
    }

    public static void printArray(final int[][] values)
    {
        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                final int value = values[y][x];
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
