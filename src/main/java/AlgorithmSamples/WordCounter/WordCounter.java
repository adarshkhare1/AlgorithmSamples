package AlgorithmSamples.WordCounter;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Assumptions
 * Words contains only alphanumeric characters
 * Word matching is case insensitive
 * Word could be separated by white space or punctuation mark (?!.,;)
 * Empty words are not counted
 */
public class WordCounter
{
    /***
     *  Using Regex based matcher instead of String.Split because of better latency performance.
     * @param inputString
     * @return
     */
    @NotNull
    public static String[] GetMostRepeatedWords(String inputString)
    {
        List<String> mostRepeatWords = new ArrayList<String>();
        int mostRepeatCount = 0;

        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        Pattern p = Pattern.compile("[a-zA-Z0-9]+");
        Matcher matcher = p.matcher(inputString);
        while (matcher.find())
        {
            String s = (matcher.group()).toLowerCase();
            mostRepeatCount = updateResult(mostRepeatWords,
                                            mostRepeatCount,
                                            wordMap,
                                            s);

        }
        return mostRepeatWords.toArray(new String[0]);
    }

    /***
     *  Using Regex based matcher instead of String.Split because of better latency performance.
     * @param inputString
     * @return
     */
    @NotNull
    public static String[] GetTopKMostRepeatedWords(String inputString, int k)
    {
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        Pattern p = Pattern.compile("[a-zA-Z0-9]+");
        Matcher matcher = p.matcher(inputString);
        while (matcher.find())
        {
            String s = (matcher.group()).toLowerCase();
            int count = wordMap.containsKey(s) ? wordMap.get(s) + 1 : 1;
            wordMap.put(s, count);
        }
        //Use priority queue to arrange word
        PriorityQueue<WordFrequencyNode> queue = GetOrderedQueueFromWordMap(wordMap);
        List<String> mostRepeatWords = new ArrayList<>();
        for (int i = 0; i < k; i++)
        {
            mostRepeatWords.add(queue.poll().str);
        }
        return mostRepeatWords.toArray(new String[0]);
    }

    @NotNull
    @Deprecated
    public static String[] GetMostRepeatedWordsSlow(String inputString)
    {
        List<String> result = new ArrayList<String>();
        int mostRepeatCount = 0;

        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        String[] words = new String[0];

        words = inputString.split("[\\s,?!.,;]+");
        for(String s: words)
        {
            s = s.toLowerCase();
            mostRepeatCount = updateResult(result,
                                            mostRepeatCount,
                                            wordMap,
                                            s);
        }
        return result.toArray(new String[0]);
    }

    private static int updateResult(List<String> mostRepeatWords, int mostRepeatCount, Map<String, Integer> wordMap, String word) {
        int count = wordMap.containsKey(word) ? wordMap.get(word) + 1 : 1;
        wordMap.put(word, count);
        if(count > mostRepeatCount)
        {
            mostRepeatCount = count;
            mostRepeatWords.clear();
            mostRepeatWords.add(word);
        }
        else if (count == mostRepeatCount)
        {
            mostRepeatWords.add(word);
        }
        return mostRepeatCount;
    }

    @NotNull
    private static PriorityQueue<WordFrequencyNode> GetOrderedQueueFromWordMap(Map<String, Integer> wordMap)
    {
        PriorityQueue<WordFrequencyNode> queue = new PriorityQueue<>(wordMap.size(), new WordFrequencyNodeComparator());
        for (Map.Entry<String, Integer> entry : wordMap.entrySet())
            queue.offer(new WordFrequencyNode(entry.getKey(), entry.getValue()));
        return queue;
    }
}
