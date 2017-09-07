package AlgorithmSamples.LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by adarshkhare on 3/19/17.
 */

public class LinkedListManipulation
{
    public static<T> T GetNthElementFromEndOfTheList(LinkedList<T> list, int nElement)
    {
        T returnElement = null;
        if (list != null )
        {
            ListIterator<T> baseIterator = list.listIterator();
            ListIterator<T> endIterator;
            for (int i = 0; i < nElement; i++)
            {
                if (baseIterator.hasNext())
                    returnElement = baseIterator.next();
                else //Not enough elements in Linked List
                    returnElement = null;
            }
            endIterator = baseIterator;
            baseIterator = list.listIterator();
            while (endIterator.hasNext())
            {
                returnElement = baseIterator.next();
                endIterator.next();
            }
        }
        return returnElement;
    }
}
