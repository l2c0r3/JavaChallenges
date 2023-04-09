package ch07_lists.intro;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class QueueExample
{
    private QueueExample()
    {
    }

    public static void main(final String[] args)
    {
        final Queue<String> waitingPersons = new LinkedList<>();

        waitingPersons.offer("Marcello");
        waitingPersons.offer("Michael");
        waitingPersons.offer("Karthi");

        while (!waitingPersons.isEmpty())
        {
            if (waitingPersons.peek().equals("Michael"))
            {
                // Am Ende "neu anstellen" und verarbeiten
                waitingPersons.offer("Michael again");
                waitingPersons.offer("Last Man");
            }
            final String nextPerson = waitingPersons.poll();
            System.out.println("Processing " + nextPerson);
        }
    }
}
