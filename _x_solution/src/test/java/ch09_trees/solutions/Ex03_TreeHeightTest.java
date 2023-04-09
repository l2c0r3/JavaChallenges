package ch09_trees.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex03_TreeHeightTest
{
    @Test
    void getHeight()
    {
        final var root = Ex03_TreeHeight.createHeightExampleTree();

        final var result = Ex03_TreeHeight.getHeight(root);

        assertEquals(4, result);
    }
}
