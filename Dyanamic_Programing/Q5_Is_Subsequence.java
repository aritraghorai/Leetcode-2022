package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:02/03/2022
 ?Program Details:392. Is Subsequence
 *https://leetcode.com/problems/is-subsequence/ 
   */
public class Q5_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i != s.length() && j == t.length())
            return false;
        return true;
    }
}
