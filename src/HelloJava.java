import javafx.scene.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

public class HelloJava {

    public static void main(String[] args)
    {
        System.out.println("Hello Moto");

        printNK(5,3);

        System.out.println(checkAllAlphabet("abcdefghijKlmnopqrstuvwXyZ"));

        if (stringContains("We Are The Champions", "ouin"))
            System.out.println("Contains ועוד איך Contains");
        else
            System.out.println("Hardluck!");

        int[] arr3 = {1,2,3,7,-7,0,10,11,12,0,0,1,1};
        System.out.println(findSubMaxSumArray(arr3));
    }

    // Q: given n and k, print an array of length n, that consists only of k distinct
        // lower case characters
    public static void printNK(int n, int k) {
        int a = 'a';
        int c = 0;

        char[] arr = new char[n];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (char)(a + (c%k));
            c++;
        }

        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);
        }

        System.out.println();
    }

    // Q: return boolean if all alphabet characters (small) are included in string
    public static boolean checkAllAlphabet(String str)
    {
        int a = 'a';
        boolean[] abc = new boolean[26];
        for(int i = 0; i < abc.length; i++)
        {
            abc[i] = false;
        }

        char[] arr = str.toLowerCase(Locale.ROOT).toCharArray();
        for(int i = 0; i < arr.length; i++)
        {
            if (!abc[arr[i] - 'a'])
                abc[arr[i] - 'a'] = true;
        }

        for(int i = 0; i < abc.length; i++) {
            if (abc[i] == false)
                return false;
        }

        return true;
    }

    // Q: return boolean if one string contains the other
    public static boolean stringContains(String all, String sub)
    {
        //return  (all.contains(sub));
        int c = 0, j = 0;
        char[] allArr = all.toCharArray();
        char[] subArr = sub.toCharArray();

        if (all.length() < sub.length())
            return false;

        int i = 0;
        while (allArr[i] != subArr[j])
            i++;

        for(; i< allArr.length; i++)
        {
            if (allArr[i] == subArr[j])
            {
                j++; c++;
            }

            if (c == subArr.length)
                return true;
        }

        return false;
    }

    // Q: return largest consecutive adjacent numbers's in array
    public static int findSubMaxSumArray(int[] arr)
    {
        int max = 0;
        boolean first = true;
        int start = -1;

        int[] arr2;
        int sum = 0;
        for(int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i] + 1 == arr[i+1])
            {
                //count++;
                sum += arr[i+1];
                if (i > 0 && (arr[i-1] + 1 != arr[i]))
                    first = true;
                if (first == true) {
                    start = i;
                    sum+=arr[i];
                    first = false;
                }
            }
            else if (start != -1)
            {
                if (sum > max)
                    max = sum;
                sum = 0;
                start = -1;
            }
        }

        return max;
    }

    // Q: check if there is a loop in list and return boolean
    public static boolean isLoop(NodeInt head)    {

        NodeInt pos = head;
        NodeInt last = null;

        while (pos!=null)
        {
            if (pos.getNextNode() == head)
                return true;

            pos = pos.getNextNode();
        }

        return false;
    }
}
