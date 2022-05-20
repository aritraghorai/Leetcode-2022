package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:20/05/2022
 ?Program Details:63. Unique Paths II
 *https://leetcode.com/problems/unique-paths-ii/
   */
public class Q14_Unique_Path_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        for (int row = n - 1; row >= 0; row--) {
            for (int colm = m - 1; colm >= 0; colm--) {
                if (obstacleGrid[row][colm] == 1) {
                    continue;
                }
                if (row == n - 1 && colm == m - 1) {
                    dp[row][colm] = 1;
                } else if (row == n - 1) {
                    dp[row][colm] = dp[row][colm + 1];
                } else if (colm == m - 1) {
                    dp[row][colm] = dp[row + 1][colm];
                } else {
                    dp[row][colm] = dp[row + 1][colm] + dp[row][colm + 1];
                }
            }
        }
        return dp[0][0];
    }
}
