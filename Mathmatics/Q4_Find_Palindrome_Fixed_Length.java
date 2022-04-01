package Mathmatics;

/*
 !Name: Aritra Ghorai
 !Date:01/04/2022
 ?Program Details:2217. Find Palindrome With Fixed Length
*https://leetcode.com/problems/find-palindrome-with-fixed-length/
   */
public class Q4_Find_Palindrome_Fixed_Length {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int pw = intLength % 2 == 0 ? (intLength / 2) - 1 : intLength / 2;
        int start = (int) Math.pow(10, pw);
        long[] res = new long[queries.length];
        int i = 0;
        for (int qu : queries) {
            String ans = (start + qu - 1) + "";
            String rev = new StringBuilder(ans).reverse().toString();
            if (intLength % 2 == 0) {
                ans += rev;
            } else {
                ans += rev.substring(1);
            }
            if (ans.length() == intLength)
                res[i] = Long.parseLong(ans);
            else
                res[i] = -1;
            i++;
        }
        return res;

    }
}
