package AlgorithmSamples.StringManipulation.Test;

import AlgorithmSamples.String.StringManipulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by adarshkhare on 3/19/17.
 */
public class StringPermutationTest
{
    @Test
    void stringBIsSameAsA()
    {
        String first = "abc";
        String second = "abc";
        Assertions.assertTrue(StringManipulation.Is_B_Permutaion_Of_A(first, second));

    }

    @Test
    void stringBIsPermutationOfA()
    {
        String first = "abcde";
        String second = "abdec";
        Assertions.assertTrue(StringManipulation.Is_B_Permutaion_Of_A(first, second));

    }

    @Test
    void stringBIsSameAsAWithRepeatChars()
    {
        String first = "abcabcdexy";
        String second = "abcdexycba";
        Assertions.assertTrue(StringManipulation.Is_B_Permutaion_Of_A(first, second));

    }

    @Test
    void oneStringEmpty()
    {
        String first = "abcabcdexu";
        String second = "";
        Assertions.assertFalse(StringManipulation.Is_B_Permutaion_Of_A(first, second));
        Assertions.assertFalse(StringManipulation.Is_B_Permutaion_Of_A(second, first));

    }
    @Test
    void oneStringNull()
    {
        String first = "abcabcdexu";
        String second = null;
        Assertions.assertFalse(StringManipulation.Is_B_Permutaion_Of_A(first, second));
        Assertions.assertFalse(StringManipulation.Is_B_Permutaion_Of_A(second, first));

    }

    @Test
    void oneStringLarge()
    {
        String first = "abcabcdexu";
        String second = "abc";
        Assertions.assertFalse(StringManipulation.Is_B_Permutaion_Of_A(first, second));
        Assertions.assertFalse(StringManipulation.Is_B_Permutaion_Of_A(second, first));

    }

    @Test
    void bothStringsEmpty()
    {
        String first = "";
        String second = "";
        Assertions.assertTrue(StringManipulation.Is_B_Permutaion_Of_A(first, second));

    }

    @Test
    void bothStringsNull()
    {
        String first = null;
        String second = null;
        Assertions.assertTrue(StringManipulation.Is_B_Permutaion_Of_A(first, second));

    }

    @Test
    void bothStringSameSizeButNotPermutation()
    {
        String first = "abcabcdexy";
        String second = "defabcdexy";
        Assertions.assertFalse(StringManipulation.Is_B_Permutaion_Of_A(first, second));
        Assertions.assertFalse(StringManipulation.Is_B_Permutaion_Of_A(second, first));

    }


}
