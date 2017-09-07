package AlgorithmSamples.WordCounter.Test;

import AlgorithmSamples.WordCounter.WordCounter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by adarshkhare on 8/25/17.
 */
public class WordCounterTest
{
    @Test
    public void getMostRepeatedWordExample()
    {
        String s = "A blue shirt cost is twenty-four dollars but a white shirt is only twenty so I bought the white shirt.";
        String[] words = WordCounter.GetMostRepeatedWords(s);
        String[] result = new String[]{"shirt"};
        Assert.assertArrayEquals("result is not same",result, words );
    }

    @Test
    public void getMostRepeatedWordTie()
    {
        String s = "My My. My, my; MY test string test Test test test";
        String[] words = WordCounter.GetMostRepeatedWords(s);
        String[] result = new String[]{"my", "test"};
        Assert.assertArrayEquals("result is not same",result, words );
    }

    @Test
    public void getMostRepeatedWordTieTwoWordsOnly()
    {
        String s = "test My";
        String[] words = WordCounter.GetMostRepeatedWords(s);
        String[] result = new String[]{"test", "my"};
        Assert.assertArrayEquals("result is not same",result, words );
    }

    @Test
    public void getMostRepeatedSingleWord()
    {
        String s = "My My. My, my; MY test string test test";
        String[] words = WordCounter.GetMostRepeatedWords(s);
        String[] result = new String[]{"my"};
        Assert.assertArrayEquals("result is not same",result, words );
    }

    @Test
    public void getTopKMostRepeatedWords()
    {
        String s = "My My. My, my; MY test string test test";
        String[] words = WordCounter.GetTopKMostRepeatedWords(s, 2);
        String[] result = new String[]{"my", "test"};
        Assert.assertArrayEquals("result is not same",result, words );
    }

    @Test
    public void getMostRepeatedEmptyString()
    {
        String s = "";
        String[] words = WordCounter.GetMostRepeatedWords(s);
        String[] result = new String[]{};
        Assert.assertArrayEquals("result is not same",result, words );
    }

    @Test
    public void getMostRepeatedSingleWordString()
    {
        String s = "test";
        String[] words = WordCounter.GetMostRepeatedWords(s);
        String[] result = new String[]{"test"};
        Assert.assertArrayEquals("result is not same",result, words );
    }
}