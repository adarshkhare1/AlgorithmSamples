package AlgorithmSamples.LinkedListManipulation.Test;

import AlgorithmSamples.LinkedList.LinkedListManipulation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by adarshkhare on 3/19/17.
 */
public class LinkedListManipulationTest
{
    @Test
    public void nThElementFromEndBasicTest()
    {
        Integer[] testArray = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        LinkedList<Integer> testList = GetTestList(testArray);
        int nElement = 0;
        Integer result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assert.assertEquals("Last element",0, result.longValue() );

        nElement = 1;
        result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assert.assertEquals("Second Last element", 1, result.longValue() );

        nElement = 9;
        result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assert.assertEquals( "First Element",9, result.longValue());

        nElement = 5;
        result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assert.assertEquals("Middle Element",5, result.longValue());
    }


    @Test
    public void nThElementFromNullListTest() {
        LinkedList<Integer> testList = null;
        int nElement = 10;
        Integer result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assert.assertNull("Null list should return null", result);

        nElement = 0;
        result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assert.assertNull("Null list should return null",result);
    }

    @Test
    public void nThElementFromListWhereIndexOutOfrangeTest() {
        Integer[] testArray = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        LinkedList<Integer> testList = GetTestList(testArray);
        int nElement = 20;
        Integer result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assert.assertNull("OutOfRange should return null", result);
    }

    @Test
    public void nThElementFromListWhereListIsEmptyTest() {
        Integer[] testArray = new Integer[]{};
        LinkedList<Integer> testList = GetTestList(testArray);
        int nElement = 0;
        Integer result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assert.assertNull("Empty list should return null", result);

        nElement = 10;
        result = LinkedListManipulation.GetNthElementFromEndOfTheList(testList, nElement);
        Assert.assertNull("Empty list should return null", result);
    }


    private LinkedList<Integer> GetTestList(Integer[] testArray)
    {
        LinkedList<Integer> testList = new LinkedList<Integer>();
        testList.addAll(Arrays.asList(testArray));
        return testList;
    }
}
