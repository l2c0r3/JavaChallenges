package ch09_trees.solutions;

import java.util.LinkedList;
import java.util.Queue;

import ch09_trees.intro.BinaryTreeNode;
import ch09_trees.utils.TreeUtils;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex12_Completeness
{
    public static void main(final String[] args)
    {
        final BinaryTreeNode<String> F = createCompletenessExampleTree();
        TreeUtils.nicePrint(F);
        System.out.println("levelorderIsComplete? " + levelorderIsComplete(F));

        // modiziere: entferne Blätter unter H
        F.right.left = null;
        F.right.right = null;
        TreeUtils.nicePrint(F);
        System.out.println("levelorderIsComplete? " + levelorderIsComplete(F));
    }

    protected static BinaryTreeNode<String> createCompletenessExampleTree()
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

    static <T> boolean isFull(final BinaryTreeNode<T> currentNode)
    {
        if (currentNode == null)
            return true;

        return isFull(currentNode.left, currentNode.right);
    }

    static <T> boolean isFull(final BinaryTreeNode<T> leftNode, final BinaryTreeNode<T> rightNode)
    {
        if (leftNode == null && rightNode == null)
            return true;

        if (leftNode != null && rightNode != null)
            return isFull(leftNode) && isFull(rightNode);

        return false;
    }

    // dazu müssen alle Leafs auf der gleichen Höhe sein
    static <T> boolean isPerfect(final BinaryTreeNode<T> parent)
    {
        if (parent == null)
            return true;

        final int height = Ex03_TreeHeight.getHeight(parent);

        return isPerfect(parent.left, parent.right, height, 1);
    }

    static <T> boolean isPerfect(final BinaryTreeNode<T> leftNode, final BinaryTreeNode<T> rightNode, final int height,
                                 final int currentLevel)
    {
        if (leftNode == null || rightNode == null)
            return false;

        if (leftNode.isLeaf() && rightNode.isLeaf())
            return onSameHeight(leftNode, rightNode, height, currentLevel);

        return isPerfect(leftNode.left, leftNode.right, height, currentLevel + 1)
                        && isPerfect(rightNode.left, rightNode.right, height, currentLevel + 1);
    }

    static <T> boolean onSameHeight(final BinaryTreeNode<T> leftNode, final BinaryTreeNode<T> rightNode,
                                    final int height, final int currentLevel)
    {
        return Ex03_TreeHeight.getHeight(leftNode) + currentLevel == height
                        && Ex03_TreeHeight.getHeight(rightNode) + currentLevel == height;
    }

    // -------------------------------------------------------------------

    static <T> boolean levelorderIsComplete(final BinaryTreeNode<T> startNode)
    {
        if (startNode == null)
            return false;

        final Queue<BinaryTreeNode<T>> toProcess = new LinkedList<>();
        toProcess.offer(startNode);

        boolean missingNode = false;

        while (!toProcess.isEmpty())
        {
            final BinaryTreeNode<T> current = toProcess.poll();

            // Nur Nachfahren auf der rechten Seite
            if (current.left == null && current.right != null)
                return false;

            // Wenn zuvor ein fehlender Knoten entdeckt wurde,
            // dann darf der nächste nur ein Blatt sein
            if (missingNode && !current.isLeaf())
                return false;

            // Nehme Subelemente auf, markiere, falls nicht vollständig
            if (current.left != null)
                toProcess.offer(current.left);
            else
                missingNode = true;

            if (current.right != null)
                toProcess.offer(current.right);
            else
                missingNode = true;
        }

        // Alle Knoten erfolgreich getestet
        return true;
    }
}
