package Dyanamic_Programing;

/* 
!Name: Aritra Ghorai
!Date:19/05/2022
?Program Details:329. Longest Increasing Path in a Matrix
*https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
  */

public class Q13_Longest_Incresing_Path_In_Matrix {
    int[][] dxy = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    int res = 0;

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(dp, matrix, i, j);
            }
        }
        return res;
    }

    public int helper(int[][] dp, int[][] matrix, int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int dist = 1;
        for (int[] d : dxy) {
            int x = d[0] + row;
            int y = d[1] + col;

            if (x < matrix.length && y < matrix[0].length && x >= 0 && y >= 0 && matrix[x][y] > matrix[row][col]) {
                dist = Math.max(dist, helper(dp, matrix, x, y) + 1);
            }
        }

        dp[row][col] = dist;
        res = Math.max(res, dist);
        return dist;
    }
}
