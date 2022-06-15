package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:14/06/2022
 ?Program Details:583. Delete Operation for Two Strings
 *https://leetcode.com/problems/delete-operation-for-two-strings/
   */
public class Q18_Delete_Operation_Of_Two_String {
    public int minDistance(String word1, String word2) {
        return helper(word1, word2, 0, 0, new Integer[word1.length() + 1][word2.length() + 1]);
    }

    public int helper(String word1, String word2, int in1, int in2, Integer[][] dp) {
        if (in1 == word1.length() || in2 == word2.length()) {
            return Math.max(word1.length() - in1, word2.length() - in2);
        }
        // *Here We Have Two Choise
        if (dp[in1][in2] != null) {
            return dp[in1][in2];
        }
        int res = Integer.MAX_VALUE;
        if (word1.charAt(in1) == word2.charAt(in2)) {
            res = Math.min(res, helper(word1, word2, in1 + 1, in2 + 1, dp));
        } else {
            res = Math.min(res, helper(word1, word2, in1 + 1, in2, dp));
            res = Math.min(res, helper(word1, word2, in1, in2 + 1, dp));
            res += 1;

        }
        return dp[in1][in2] = res;
    }
}
