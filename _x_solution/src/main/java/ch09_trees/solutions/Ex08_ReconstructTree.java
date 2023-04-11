package ch09_trees.solutions;

import java.util.Arrays;
import java.util.List;

import ch09_trees.intro.BinaryTreeNode;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex08_ReconstructTree
{
    private Ex08_ReconstructTree()
    {
    }


    static BinaryTreeNode<Integer> reconstruct(final int[] values)
    {
        // rekursiver Abbruch
        if (values.length == 0)
        {
            return null;
        }

        final int midIdx = values.length / 2;

        final int midValue = values[midIdx];
        final BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(midValue);

        // rekursiver Abbruch
        if (values.length == 1)
        {
            return newNode;
        }

        // rekursiver Abbstieg
        final int[] leftPart = Arrays.copyOfRange(values, 0, midIdx);
        final int[] rightPart = Arrays.copyOfRange(values, midIdx + 1,
                                                   values.length);

        newNode.left = reconstruct(leftPart);
        newNode.right = reconstruct(rightPart);

        return newNode;
    }

    static <T> BinaryTreeNode<T> reconstruct(final List<T> preorderValues, final List<T> inorderValues)
    {
        if (preorderValues.size() != inorderValues.size())
            throw new IllegalStateException("inputs differ in length");

        // rekursiver Abbruch
        if (preorderValues.size() == 0 || inorderValues.size() == 0)
            return null;

        final T rootValue = preorderValues.get(0);
        final BinaryTreeNode<T> root = new BinaryTreeNode<>(rootValue);

        // rekursiver Abbruch
        if (preorderValues.size() == 1 && inorderValues.size() == 1)
        {
            return root;
        }

        // rekursiver Abbstieg
        final int index = inorderValues.indexOf(rootValue);

        // linker und rechter Teil für Preorder
        root.left = reconstruct(preorderValues.subList(1, index + 1), inorderValues.subList(0, index));
        root.right = reconstruct(preorderValues.subList(index + 1, preorderValues.size()),
                                 inorderValues.subList(index + 1, inorderValues.size()));

        return root;
    }

    static <T> BinaryTreeNode<T> reconstructClearer(final List<T> preorderValues, final List<T> inorderValues)
    {
        // rekursiver Abbruch
        if (preorderValues.size() == 0 || inorderValues.size() == 0)
        {
            return null;
        }

        final T rootValue = preorderValues.get(0);
        final BinaryTreeNode<T> root = new BinaryTreeNode<>(rootValue);

        // rekursiver Abbruch
        if (preorderValues.size() == 1 && inorderValues.size() == 1)
        {
            return root;
        }

        // rekursiver Abbstieg
        final int index = inorderValues.indexOf(rootValue);

        // linker und rechter Teil für Inorder
        final List<T> leftInoder = inorderValues.subList(0, index);
        final List<T> rightInoder = inorderValues.subList(index + 1, inorderValues.size());

        // linker und rechter Teil für Preorder
        final List<T> leftPreorder = preorderValues.subList(1, 1 + index);
        final List<T> rightPreorder = preorderValues.subList(index + 1, preorderValues.size());

        root.left = reconstruct(leftPreorder, leftInoder);
        root.right = reconstruct(rightPreorder, rightInoder);

        return root;
    }
}
