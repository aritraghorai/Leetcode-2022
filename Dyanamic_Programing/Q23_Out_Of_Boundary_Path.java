package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:16/07/2022
 ?Program Details:576. Out of Boundary Paths
 *https://leetcode.com/problems/out-of-boundary-paths/
   */
public class Q23_Out_Of_Boundary_Path {
    private int mod = (int) (1e9 + 7);

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[m + 1][n + 1][maxMove + 1];
        return helper(startRow, startColumn, m, n, maxMove, dp);

    }

    private int helper(int row, int colm, int m, int n, int maxMove, Integer[][][] dp) {
        if (row == -1 || colm == -1 || row == m || colm == n)
            return 1;
        if (maxMove <= 0)
            return 0;
        if (dp[row][colm][maxMove] != null) {
            return dp[row][colm][maxMove];
        }
        int total = 0;
        total = (total + helper(row + 1, colm, m, n, maxMove - 1, dp)) % mod;
        total = (total + helper(row, colm + 1, m, n, maxMove - 1, dp)) % mod;
        total = (total + helper(row - 1, colm, m, n, maxMove - 1, dp)) % mod;
        total = (total + helper(row, colm - 1, m, n, maxMove - 1, dp)) % mod;
        return dp[row][colm][maxMove] = total;
    }
}
