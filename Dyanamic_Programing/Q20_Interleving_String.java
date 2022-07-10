package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:09/07/2022
 ?Program Details:97. Interleaving String
*https://leetcode.com/problems/interleaving-string/ 
   */
public class Q20_Interleving_String {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        return helper(s1, s2, s3, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]);
    }

    public boolean helper(String s1, String s2, String s3, int i, int j, Boolean[][] dp) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        if (dp[i][j] != null)
            return false;
        boolean res = false;
        if (i != s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            res |= helper(s1, s2, s3, i + 1, j, dp);
        }
        if (j != s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            res |= helper(s1, s2, s3, i, j + 1, dp);
        }
        return dp[i][j] = res;
    }
}
