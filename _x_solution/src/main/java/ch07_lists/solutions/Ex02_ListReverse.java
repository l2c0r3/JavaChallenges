package ch07_lists.solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex02_ListReverse
{
    private Ex02_ListReverse()
    {
    }

    // Annahme: Indizierter Zugriff mit O(1)
    static <T> List<T> listReverse(final List<T> inputs)
    {
        final List<T> result = new ArrayList<>();

        for (int i = inputs.size() - 1; i >= 0; i--)
        {
            final T origValue = inputs.get(i);
            result.add(origValue);
        }
        return result;
    }

    static <T> List<T> listReverseWithListIterator(final List<T> inputs)
    {
        final List<T> result = new ArrayList<>();

        final ListIterator<T> it = inputs.listIterator(inputs.size());
        while (it.hasPrevious())
        {
            final T origValue = it.previous();
            result.add(origValue);
        }

        return result;
    }

    // Annahme: Indizierter Zugriff mit O(1)
    static <T> void listReverseInplace(final List<T> inputs)
    {
        // laufe von links und rechts, tausche jeweils die Elemente
        int left = 0;
        int right = inputs.size() - 1;

        while (left < right)
        {
            final T leftValue = inputs.get(left);
            final T rightValue = inputs.get(right);

            inputs.set(left, rightValue);
            inputs.set(right, leftValue);

            left++;
            right--;
        }
    }

    static <T> List<T> listReverseWithStack(final List<T> inputs)
    {
        // Idee: Durchlaufe die Liste von vorne nach hinten (performant) und
        // befülle einen Stack
        final Stack<T> allValues = new Stack<>();
        final Iterator<T> it = inputs.iterator();
        while (it.hasNext())
        {
            allValues.push(it.next());
        }

        // Entleere den Stack und befülle eine neue Liste
        final List<T> result = new ArrayList<>();
        while (!allValues.isEmpty())
        {
            final T value = allValues.pop();
            result.add(value);
        }
        return result;
    }
}
