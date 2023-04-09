package ch09_trees.solutions;

import java.util.ArrayList;
import java.util.List;

import ch09_trees.intro.BinaryTreeNode;
import ch09_trees.utils.TreeUtils;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex08_ReconstructBSTJustPreorder
{
    private Ex08_ReconstructBSTJustPreorder()
    {
    }

    public static void main(final String[] args)
    {
        final var root1 = reconstruct(List.of(4, 2, 1, 3, 6, 5, 7));
        TreeUtils.nicePrint(root1);

        final var root2 = reconstruct(List.of(5, 4, 2, 1, 3, 7, 6, 8));
        TreeUtils.nicePrint(root2);
    }

    static <T extends Comparable<T>> BinaryTreeNode<T> reconstruct(final List<T> preorderValues)
    {
        // rekursiver Abbruch
        if (preorderValues.isEmpty())
            return null;

        final T rootValue = preorderValues.get(0);
        final BinaryTreeNode<T> root = new BinaryTreeNode<>(rootValue);

        // rekursiver Abbstieg
        final List<T> leftValues = new ArrayList<>(preorderValues);
        leftValues.removeIf(value -> value.compareTo(rootValue) >= 0);
        final List<T> rightValues = new ArrayList<>(preorderValues);
        rightValues.removeIf(value -> value.compareTo(rootValue) <= 0);

        root.left = reconstruct(leftValues);
        root.right = reconstruct(rightValues);

        return root;
    }
}
