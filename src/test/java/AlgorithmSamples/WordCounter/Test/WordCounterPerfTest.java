package AlgorithmSamples.WordCounter.Test;

import AlgorithmSamples.WordCounter.WordCounter;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by adarshkhare on 8/25/17.
 */
public class WordCounterPerfTest
{
    @Ignore
    @Test
    public void getMostRepeatedWordPerformance()
    {
        StringBuilder sb = new StringBuilder(4*1024*1024);
        sb.append("My My. My, my; MY test string test test test");
        for(long i =0;i<10000;i++)
        {
            sb.append(" my"+i);
        }
        String s = sb.toString();
        int nRepeat = 1000;
        String[] words = new String[]{};
        //Exclude warmup time
        {
            words = WordCounter.GetMostRepeatedWords(s);
            words = WordCounter.GetMostRepeatedWordsSlow(s);
        }
        long currentTimeSeconds = System.currentTimeMillis();
        for(int i=0;i<nRepeat;i++)
        {
             words = WordCounter.GetMostRepeatedWords(s);
        }
        System.out.println("1>>" + (System.currentTimeMillis() - currentTimeSeconds) + " ms");
        currentTimeSeconds = System.currentTimeMillis();
        for(int i=0;i<nRepeat;i++)
        {
            words = WordCounter.GetMostRepeatedWordsSlow(s);
        }
        System.out.println("2>>" + (System.currentTimeMillis()-currentTimeSeconds) + " ms");
        String[] result = new String[]{"my"};
        Assert.assertArrayEquals("result is not same",result, words );
    }
}