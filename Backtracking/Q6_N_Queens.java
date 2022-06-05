package Backtracking;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:04/06/2022
 ?Program Details:51. N-Queens
 *https://leetcode.com/problems/n-queens/
   */
public class Q6_N_Queens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(new boolean[n][n], 0, new ArrayList<String>(), res);
        return res;
    }

    public void helper(boolean[][] matrix, int row, List<String> temp, List<List<String>> res) {
        if (row == matrix.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int colm = 0; colm < matrix[0].length; colm++) {
            if (isOk(matrix, row, colm)) {
                matrix[row][colm] = true;
                temp.add(getString(matrix[0].length, colm));
                helper(matrix, row + 1, temp, res);
                matrix[row][colm] = false;
                temp.remove(temp.size() - 1);
            }
        }
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

    private String getString(int length, int colm) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (colm == i) {
                sb.append('Q');
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

}
