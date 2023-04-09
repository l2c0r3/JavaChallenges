package ch09_trees.solutions;

import java.util.Stack;
import java.util.function.Consumer;

import ch09_trees.intro.BinaryTreeNode;
import ch09_trees.utils.TreeUtils;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex02_IterativeTreeTraversals
{
    private Ex02_IterativeTreeTraversals()
    {
    }

    public static void main(final String[] args)
    {
        final BinaryTreeNode<String> d4 = ExampleTrees.createExampleTree();
        traverse(d4);

        final BinaryTreeNode<String> a = new BinaryTreeNode<>("a");
        final BinaryTreeNode<String> b = new BinaryTreeNode<>("b");
        final BinaryTreeNode<String> c = new BinaryTreeNode<>("c");
        final BinaryTreeNode<String> d = new BinaryTreeNode<>("d");
        final BinaryTreeNode<String> e = new BinaryTreeNode<>("e");
        final BinaryTreeNode<String> f = new BinaryTreeNode<>("f");
        final BinaryTreeNode<String> g = new BinaryTreeNode<>("g");
        final BinaryTreeNode<String> h = new BinaryTreeNode<>("h");
        final BinaryTreeNode<String> i = new BinaryTreeNode<>("i");
        final BinaryTreeNode<String> j = new BinaryTreeNode<>("j");
        final BinaryTreeNode<String> k = new BinaryTreeNode<>("k");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.left = h;
        e.left = i;
        e.right = j;
        c.left = f;
        c.right = g;
        f.right = k;

        traverse(a);
    }

    private static void traverse(final BinaryTreeNode<String> d4)
    {
        TreeUtils.nicePrint(d4);

        System.out.println("\ninorder iterative");
        inorderIterative(d4, str -> System.out.print(str + " "));

        System.out.println("\npreorder iterative");
        preorderIterative(d4, str -> System.out.print(str + " "));

        System.out.println("\npostorder iterative");
        postorderIterative(d4, str -> System.out.print(str + " "));
    }

    static <T> void preorderIterative(final BinaryTreeNode<T> startNode, final Consumer<T> action)
    {
        if (startNode == null)
            return;

        final Stack<BinaryTreeNode<T>> nodesToProcess = new Stack<>();
        nodesToProcess.push(startNode);

        while (!nodesToProcess.isEmpty())
        {
            final BinaryTreeNode<T> currentNode = nodesToProcess.pop();
            action.accept(currentNode.item);

            // damit links zu erst verarbeitet wird, Reihenfolge umdrehen
            if (currentNode.right != null)
                nodesToProcess.push(currentNode.right);

            if (currentNode.left != null)
                nodesToProcess.push(currentNode.left);
        }
    }

    static <T> void inorderIterative(final BinaryTreeNode<T> startNode, final Consumer<T> action)
    {
        if (startNode == null)
            return;

        final Stack<BinaryTreeNode<T>> nodesToProcess = new Stack<>();
        BinaryTreeNode<T> currentNode = startNode;
        while (!nodesToProcess.isEmpty() || currentNode != null)
        {
            if (currentNode != null)
            {
                nodesToProcess.push(currentNode);
                currentNode = currentNode.left;
            }
            else
            {
                currentNode = nodesToProcess.pop();
                action.accept(currentNode.item);

                currentNode = currentNode.right;
            }
        }
    }

    static <T> void postorderIterative(final BinaryTreeNode<T> startNode, final Consumer<T> action)
    {
        if (startNode == null)
            return;

        final Stack<BinaryTreeNode<T>> nodesToProcess = new Stack<>();
        BinaryTreeNode<T> currentNode = startNode;
        BinaryTreeNode<T> lastNodeVisited = null;

        while (!nodesToProcess.isEmpty() || currentNode != null)
        {
            if (currentNode != null)
            {
                // Abstieg nach links
                //     System.out.println("currentNode: " + currentNode);
                nodesToProcess.push(currentNode);
                // System.out.println("nodesToProcess: " + nodesToProcess);
                currentNode = currentNode.left;
            }
            else
            {
                final BinaryTreeNode<T> peekNode = nodesToProcess.peek();
                //            System.out.println("peekNode: " + peekNode);
                // Abstieg nach rechts
                if (peekNode.right != null && lastNodeVisited != peekNode.right)
                {
                    currentNode = peekNode.right;
                }
                else
                {
                    // Verarbeitung von Sub-Wurzel oder Leaf
                    lastNodeVisited = nodesToProcess.pop();
                    action.accept(lastNodeVisited.item);
                }
            }
        }
    }
}