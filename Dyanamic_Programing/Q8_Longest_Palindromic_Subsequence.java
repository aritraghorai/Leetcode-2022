package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:10/03/2022
 ?Program Details:Longest Palindromic Subsequence
 *https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1/ 
 *https://leetcode.com/problems/longest-palindromic-subsequence/
   */
public class Q8_Longest_Palindromic_Subsequence {
    public int longestPalinSubseq(String S) {
        return helper(S.toCharArray(), 0, S.length() - 1, new Integer[S.length() + 1][S.length() + 1]);
    }

    public int helper(char[] s, int a, int b, Integer[][] dp) {
        if (a > b) {
            return 0;
        }
        if (a == b) {
            return 1;
        }
        if (dp[a][b] != null)
            return dp[a][b];
        if (s[a] == s[b]) {
            return dp[a][b] = 2 + helper(s, a + 1, b - 1, dp);
        } else {
            return dp[a][b] = Math.max(helper(s, a + 1, b, dp), helper(s, a, b - 1, dp));
        }
    }
}
