/**
 * Created by adarshkhare on 3/18/17.
 */
public class StringManipulation
{
    public static String ReverseString(String strIn) {
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
}
