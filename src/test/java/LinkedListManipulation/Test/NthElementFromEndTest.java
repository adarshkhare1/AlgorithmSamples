package LinkedListManipulation.Test;

import AlgorithmSamples.LinkedListManipulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by adarshkhare on 3/19/17.
 */
public class NthElementFromEndTest {
    @Test
    void nThElementFromEndBasicTest()
    {
        Integer[] testArray = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        LinkedList<Integer> testList = GetTestList(testArray);
        int nElement = 0;
        Integer result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assertions.assertEquals(0, result.longValue(), "Last element");

        nElement = 1;
        result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assertions.assertEquals(1, result.longValue(), "Second Last element");

        nElement = 9;
        result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assertions.assertEquals(9, result.longValue(), "First Element");

        nElement = 5;
        result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assertions.assertEquals(5, result.longValue(), "Middle Element");
    }


    @Test
    void nThElementFromNullListTest() {
        LinkedList<Integer> testList = null;
        int nElement = 10;
        Integer result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assertions.assertNull(result, "Null list should return null");

        nElement = 0;
        result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assertions.assertNull(result, "Null list should return null");
    }

    @Test
    void nThElementFromListWhereIndexOutOfrangeTest() {
        Integer[] testArray = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        LinkedList<Integer> testList = GetTestList(testArray);
        int nElement = 20;
        Integer result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assertions.assertNull(result, "OutOfRange should return null");
    }

    @Test
    void nThElementFromListWhereListIsEmptyTest() {
        Integer[] testArray = new Integer[]{};
        LinkedList<Integer> testList = GetTestList(testArray);
        int nElement = 0;
        Integer result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assertions.assertNull(result, "Empty list should return null");

        nElement = 10;
        result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assertions.assertNull(result, "Empty list should return null");
    }


    private LinkedList<Integer> GetTestList(Integer[] testArray)
    {
        LinkedList<Integer> testList = new LinkedList<Integer>();
        testList.addAll(Arrays.asList(testArray));
        return testList;
    }
}
