package String;

/*
 !Name: Aritra Ghorai
 !Date:19/03/2022
 ?Program Details:2207. Maximize Number of Subsequences in a String
*https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string/
   */
public class Q7_MaxiMize_The_Number_Of_Subsequence {
    public long maximumSubsequenceCount(String text, String pattern) {
        long max = 0, count = 1, res = 0;
        // * Best place pattern[0] at frist of the text
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(1)) {
                res += count;
            }
            if (text.charAt(i) == pattern.charAt(0))
                count++;
        }
        max = Math.max(max, res);
        // *Best place pattern[1] at last of the text
        res = 0;
        count = 1;
        for (int j = text.length() - 1; j >= 0; j--) {
            if (text.charAt(j) == pattern.charAt(0)) {
                res += count;
            }
            if (text.charAt(j) == pattern.charAt(1)) {
                count++;
            }
        }
        return Math.max(res, max);
    }
}
