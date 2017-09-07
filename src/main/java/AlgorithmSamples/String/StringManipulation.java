package AlgorithmSamples.String;

import java.util.Arrays;

/**
 * Created by adarshkhare on 3/18/17.
 */
public class StringManipulation
{
    public static String ReverseString(String strIn)
    {
        if (strIn == null)
        {
            return null;
        }
        else
        {
            char[] chars = strIn.toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = temp;
            }
            return new String(chars);
        }
    }

    public static Boolean Is_B_SubString_Of_A(String stringA, String stringB)
    {
        if(stringB == null || stringB.isEmpty())
        {
            return true;
        }
        else if (stringA == null || stringA.isEmpty() || stringB.length() > stringA.length())
        {
            return false;
        }
        else
        {

            char[] charsB = stringB.toCharArray();
            char[] charsA = stringA.toCharArray();
            for (int i = 0; i < charsA.length - charsB.length; i++)
            {
                int j = 0;
                for (; j < charsB.length; j++)
                {
                    if(charsA[i+j] != charsB[j])
                        break;
                }
                if(j == charsB.length)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void EscapeSpacesInCharBuffer(char[] buffer) throws Exception
    {
        if(buffer == null || buffer.length == 0 )
        {
            return;
        }
        //First count number of spaces
        int nSpaces = 0;
        int strLen = 0;
        for(char c:buffer)
        {
            if (c == 0x0) break;
            strLen++;
            if(c == ' ') nSpaces++;
        }
        int bufferEnd =  strLen + 2 * nSpaces;
        if(buffer.length < bufferEnd-1)
        {
            throw new Exception("Insufficient Buffer Space");
        }
        else
        {
            int pos = bufferEnd - 1;
            for(int i = strLen - 1; i >= 0 ; i--)
            {
                if(buffer[i] == ' ')
                {
                    buffer[pos-2] = '%';
                    buffer[pos-1] = '2';
                    buffer[pos] = '0';
                    pos = pos - 3;
                }
                else
                {
                    buffer[pos] = buffer[i];
                    pos = pos - 1;
                }
            }
        }
    }

    /**
     * @param stringA First String
     * @param stringB Second String
     * @return true if second string contains same set of characters as first string.
     */
    public static Boolean Is_B_Permutaion_Of_A(String stringA, String stringB)
    {
        if(stringA == null && stringB == null)
        {
            return true;
        }
        else if((stringA == null && stringB != null)
            || (stringA != null && stringB == null)
            || (stringA.length() != stringB.length()))
        {
            return false;
        }
        else
        {
            int[] charFlags = new int[255];
            Arrays.fill(charFlags, 0);
            for(char charA: stringA.toCharArray())
                charFlags[(short) charA]++;

            for(char charB: stringB.toCharArray())
            {
                if(charFlags[(short)charB] != 0)
                    charFlags[(short) charB]--;
                else
                    return false;
            }
            for(int flag:charFlags)
            {
                if(flag != 0) return false;
            }
            return true;
        }

    }
}
