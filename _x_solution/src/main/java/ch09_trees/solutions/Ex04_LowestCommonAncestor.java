package ch09_trees.solutions;

import ch09_trees.intro.BinaryTreeNode;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex04_LowestCommonAncestor
{
    private Ex04_LowestCommonAncestor()
    {
    }

    static BinaryTreeNode<Integer> findLCA(final BinaryTreeNode<Integer> startNode, final int value1, final int value2)
    {
        if (startNode == null)
            return null;

        final int currentValue = startNode.item;

        if (value1 < currentValue && value2 < currentValue)
            return findLCA(startNode.left, value1, value2);

        if (value1 > currentValue && value2 > currentValue)
            return findLCA(startNode.right, value1, value2);

        // es gilt value1 < current && value2 < current bzw.
        // value2 < current && value1 > current
        return startNode;
    }

    static <T extends Comparable<T>> BinaryTreeNode<T> findLCA(final BinaryTreeNode<T> startNode, final T value1,
                                                               final T value2)
    {
        if (startNode == null)
            return null;

        final T currentValue = startNode.item;

        if (value1.compareTo(currentValue) < 0 && value2.compareTo(currentValue) < 0)
        {
            return findLCA(startNode.left, value1, value2);
        }

        if (value1.compareTo(currentValue) > 0 && value2.compareTo(currentValue) > 0)
        {
            return findLCA(startNode.right, value1, value2);
        }

        return startNode;
    }
}
