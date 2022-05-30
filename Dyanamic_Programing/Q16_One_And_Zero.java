package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:23/05/2022
 ?Program Details:474. Ones and Zeroes
 *https://leetcode.com/problems/ones-and-zeroes/ 
   */
public class Q16_One_And_Zero {
    public int findMaxForm(String[] strs, int m, int n) {
        var dp = new Integer[m + 1][n + 1][strs.length + 1];
        return helper(strs, m, n, 0, dp);
    }

    public int helper(String[] st, int n, int m, int index, Integer[][][] dp) {
        if (index == st.length || m + n == 0) {
            return 0;
        }
        if (dp[n][m][index] != null) {
            return dp[n][m][index];
        }
        int[] co = count(st[index]);
        int res = 0;
        if (n - co[0] >= 0 && m - co[1] >= 0) {
            res = helper(st, n - co[0], m - co[1], index + 1, dp);
        }
        res = Math.max(res, helper(st, n, m, index + 1, dp));
        return dp[n][m][index] = res;
    }

    public int[] count(String s) {
        int[] res = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '0') {
                res[0]++;
            } else {
                res[1]++;
            }
        }
        return res;
    }

}
