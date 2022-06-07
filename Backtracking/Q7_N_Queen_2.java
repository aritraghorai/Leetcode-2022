package Backtracking;

/*
 !Name: Aritra Ghorai
 !Date:05/06/2022
 ?Program Details:52. N-Queens II
*https://leetcode.com/problems/n-queens-ii/
   */
public class Q7_N_Queen_2 {
    public int totalNQueens(int n) {
        return helper(new boolean[n][n], 0);
    }

    private int helper(boolean[][] matrix, int row) {
        if (row == matrix.length) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if (isOk(matrix, row, i)) {
                matrix[row][i] = true;
                res += helper(matrix, row + 1);
                matrix[row][i] = false;
            }

        }
        return res;
    }

    private boolean isOk(boolean[][] matrix, int row, int colm) {
        // * Check Uppder
        for (int i = row - 1; i >= 0; i--) {
            if (matrix[i][colm]) {
                return false;
            }
        }
        // ?Left Upper Corner
        for (int i = row - 1, j = colm - 1; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j]) {
                return false;
            }
        }
        // ?Right Upper Corner
        for (int i = row - 1, j = colm + 1; i >= 0 && j < matrix[0].length; i--, j++) {
            if (matrix[i][j]) {
                return false;
            }
        }
        return true;
    }

}
