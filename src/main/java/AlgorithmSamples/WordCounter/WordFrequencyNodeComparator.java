package AlgorithmSamples.WordCounter;

import java.util.Comparator;

public class WordFrequencyNodeComparator implements Comparator<WordFrequencyNode>
{
    @Override
    public int compare(WordFrequencyNode o1, WordFrequencyNode o2)
    {
        if (o1.freq == o2.freq) return o1.str.compareTo(o2.str);
        else return o2.freq - o1.freq;
    }
}
