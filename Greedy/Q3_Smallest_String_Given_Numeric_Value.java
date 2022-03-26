package Greedy;

/*
 !Name: Aritra Ghorai
 !Date:22/03/2022
 ?Program Details:1663. Smallest String With A Given Numeric Value
 *https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
   */
public class Q3_Smallest_String_Given_Numeric_Value {
    public static void main(String[] args) {
        System.out.println(getSmallestString(3, 27));
        System.out.println(getSmallestString(5, 73));
    }

    public static String getSmallestString(int n, int k) {
        char[] res = new char[n];
        int i = n - 1;
        while (i >= 0) {
            if (k > 26 && k - 26 > i) {
                res[i] = (char) (26 + 'a' - 1);
                k -= 26;
                i--;
            } else {
                int newChar = k - i;
                if (newChar > 26)
                    newChar %= 26;
                res[i] = (char) (newChar + 'a' - 1);
                k -= newChar;
                i--;
            }
        }
        return new String(res);
    }

}
