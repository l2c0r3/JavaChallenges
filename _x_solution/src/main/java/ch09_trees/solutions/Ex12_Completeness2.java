package ch09_trees.solutions;

import ch09_trees.intro.BinaryTreeNode;
import ch09_trees.utils.TreeUtils;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex12_Completeness2
{
    public static void main(final String[] args)
    {
        final BinaryTreeNode<String> F = createCompletnessExampleTree();
        TreeUtils.nicePrint(F);
        System.out.println("isComplete? " + isComplete(F));
        System.out.println("isCompleteRec? " + isCompleteRec(F));

        // modiziere: entferne Blätter unter H
        F.right.left = null;
        F.right.right = null;
        TreeUtils.nicePrint(F);
        System.out.println("isComplete? " + isComplete(F));
        System.out.println("isCompleteRec? " + isCompleteRec(F));
    }

    protected static BinaryTreeNode<String> createCompletnessExampleTree()
    {
        final BinaryTreeNode<String> F = new BinaryTreeNode<>("F");
        TreeUtils.insert(F, "D");
        TreeUtils.insert(F, "H");
        TreeUtils.insert(F, "B");
        TreeUtils.insert(F, "E");
        TreeUtils.insert(F, "A");
        TreeUtils.insert(F, "C");
        TreeUtils.insert(F, "G");
        TreeUtils.insert(F, "I");
        return F;
    }

    static <T> int nodeCount(final BinaryTreeNode<T> startNode)
    {
        if (startNode == null)
            return 0;

        return 1 + nodeCount(startNode.left) + nodeCount(startNode.right);
    }

    static <T> boolean isFull(final BinaryTreeNode<T> parent)
    {
        if (parent == null)
            return true;

        return isFull(parent.left, parent.right);
    }

    static <T> boolean isFull(final BinaryTreeNode<T> leftNode,
                              final BinaryTreeNode<T> rightNode)
    {
        if (leftNode == null && rightNode == null)
            return true;


        if (leftNode != null && rightNode != null)
        {
            return isFull(leftNode.left, leftNode.right) &&
                            isFull(rightNode.left, rightNode.right);
        }

        return false;
    }

    // -------------------------------------------------------------------
    static <T> boolean isComplete(final BinaryTreeNode<T> startNode)
    {
        // Nummeriere die Positionen gemäss Levelorder durch, dann
        // kann man diese auf ein Array der Anzahl der Knoten abbilden.
        // Falls der Baumm wirklich vollständig ist, dann sollte
        // jede Arrayposition mit einem Wert belegt werden, wenn man
        // folgende Berechnung vornimmt: Position i, linker Nachfolger
        // Position i * 2 + 1, rechter Nachfolger Position i * 2 + 2

        final int nodeCount = nodeCount(startNode);

        final boolean[] nodeExists = new boolean[nodeCount];

        // jetzt durchlaufen wir den Baum von der Wurzel nach unten
        traverseAndMark(startNode, nodeExists, 0);

        return allAssigned(nodeExists);
    }

    static <T> void traverseAndMark(final BinaryTreeNode<T> startNode, final boolean[] nodeExists, final int pos)
    {
        // Abbruch
        if (startNode == null)
            return;
        if (pos >= nodeExists.length)
            return;

        // Aktion
        nodeExists[pos] = true;

        traverseAndMark(startNode.left, nodeExists, pos * 2 + 1);
        traverseAndMark(startNode.right, nodeExists, pos * 2 + 2);
    }

    private static boolean allAssigned(final boolean[] nodeExists)
    {
        for (final boolean exists : nodeExists)
            if (!exists)
                return false;

        return true;
    }

    // -------------------------------------------------------------------

    public static <T>  boolean isCompleteRec(final BinaryTreeNode<T> startNode)
    {
        return isCompleteRec(startNode, 0, nodeCount(startNode));
    }

    public static <T> boolean isCompleteRec(final BinaryTreeNode<T> startNode,
                                            final int pos,
                                            final int nodeCount)
    {
        if (startNode == null)
            return true;
        if (pos >= nodeCount)
            return false;

        if (!isCompleteRec(startNode.left, 2* pos + 1, nodeCount))
            return false;

        if (!isCompleteRec(startNode.right, 2* pos + 2, nodeCount))
            return false;

        return true;
    }
}
