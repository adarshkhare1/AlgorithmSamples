import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Created by adarshkhare on 3/19/17.
 */
public class SubStringTest
{

    @Test
    void is_B_SubString_Of_A_When_B_IsNull()
    {
        Assert.assertTrue(StringManipulation.Is_B_SubString_Of_A("abc", null));
    }

    @Test
    void is_B_SubString_Of_A_When_B_IsEmpty()
    {
        Assert.assertTrue(StringManipulation.Is_B_SubString_Of_A("abc", ""));
    }

    @Test
    void is_B_SubString_Of_A_When_B_IsSubString()
    {
        Assert.assertTrue(StringManipulation.Is_B_SubString_Of_A("abcdef", "bcd"));
    }

    @Test
    void is_B_SubString_Of_A_When_B_IsNotSubString()
    {
        Assert.assertFalse(StringManipulation.Is_B_SubString_Of_A("abcdef", "bqd"));
    }

}
