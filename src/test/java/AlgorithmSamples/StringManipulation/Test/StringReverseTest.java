package AlgorithmSamples.StringManipulation.Test;

import AlgorithmSamples.String.StringManipulation;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Created by adarshkhare on 3/19/17.
 */
class StringReverseTest
{
    @Test
    void reverseString()
    {
        String reverse = StringManipulation.ReverseString("abcde");
        Assert.assertEquals("Strings are not equal", "edcba",reverse );

    }

    @Test
    void reverseStringWithOneChar()
    {
        String reverse = StringManipulation.ReverseString("a");
        Assert.assertEquals("Strings are not equal", "a",reverse );
    }

    @Test
    void reverseNullString()
    {
        String reverse = StringManipulation.ReverseString(null);
        Assert.assertNull("Reverse strings is not null", reverse );
    }

    @Test
    void reverseEmptyString()
    {

        String reverse = StringManipulation.ReverseString("");
        Assert.assertEquals("Strings are not equal", "",reverse );

    }

}