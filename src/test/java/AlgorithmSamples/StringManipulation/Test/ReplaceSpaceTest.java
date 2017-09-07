package AlgorithmSamples.StringManipulation.Test;

import AlgorithmSamples.String.StringManipulation;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by adarshkhare on 3/19/17.
 */
public class ReplaceSpaceTest
{
    @Test
    public void escapeSpaceInEmptyString() throws Exception
    {
        char[] testBuffer = getTestBuffer("", 0);
        StringManipulation.EscapeSpacesInCharBuffer(testBuffer);
        String expectedResult = "";
        AssertResult(expectedResult, testBuffer);

    }

    @Test
    public void escapeSpaceInSingleCharString() throws Exception
    {
        char[] testBuffer = getTestBuffer("a", 0);
        StringManipulation.EscapeSpacesInCharBuffer(testBuffer);
        String expectedResult = "a";
        AssertResult(expectedResult, testBuffer);

    }

    @Test
    public void escapeSingleCharSpace() throws Exception
    {
        char[] testBuffer = getTestBuffer(" ", 2);
        StringManipulation.EscapeSpacesInCharBuffer(testBuffer);
        String expectedResult = "%20";
        AssertResult(expectedResult, testBuffer);

    }

    @Test
    public void escapeSpaceValidString() throws Exception
    {
        char[] testBuffer = getTestBuffer("a b", 2);
        StringManipulation.EscapeSpacesInCharBuffer(testBuffer);
        String expectedResult = "a%20b";
        AssertResult(expectedResult, testBuffer);

    }

    @Test
    public void escapeSpaceValidStringWithMultipleSpaces() throws Exception
    {
        char[] testBuffer = getTestBuffer("a b c", 4);
        StringManipulation.EscapeSpacesInCharBuffer(testBuffer);
        String expectedResult = "a%20b%20c";
        AssertResult(expectedResult, testBuffer);

    }

    @Test
    public void escapeSpaceValidStringWithAllSpaces() throws Exception
    {
        char[] testBuffer = getTestBuffer("   ", 6);
        StringManipulation.EscapeSpacesInCharBuffer(testBuffer);
        String expectedResult = "%20%20%20";
        AssertResult(expectedResult, testBuffer);

    }

    @Test
    public void escapeSpaceValidStringINlargeBuffer() throws Exception
    {
        char[] testBuffer = getTestBuffer("a b c", 10);
        StringManipulation.EscapeSpacesInCharBuffer(testBuffer);
        String expectedResult = "a%20b%20c";
        AssertResult(expectedResult, testBuffer);

    }

    private void AssertResult(String expectedResult, char[] resultBuffer) {
        Assert.assertEquals("Rsult is not expected",
                expectedResult,
                String.valueOf(resultBuffer, 0, expectedResult.length()));
    }

    /**
     * @param testString String to add in buffer
     * @param extraCharSpace extra characters to add at end of buffer
     * @return An array of characters for test buffer.
     */
    private char[] getTestBuffer(String testString, int extraCharSpace)
    {
        char[] buffer = new char[testString.length()+extraCharSpace];
        Arrays.fill(buffer, '\0');
        int i = 0;
        for(char c:testString.toCharArray())
        {
            buffer[i++] = c;
        }
        return buffer;
    }
}
