package Backtracking;

/*
 !Name: Aritra Ghorai
 !Date:24/11/2022
 ?Program Details: 79. Word Search
 *https://leetcode.com/problems/word-search/
   */
public class Q8_WordSearch {
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean exist(char[][] board, String word) {
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    res |= isValid(board, word.toCharArray(), i, j, 0);
                }
            }
        }

        return res;
    }

    public boolean isValid(char[][] board, char[] word, int row, int col, int idx) {
        if (idx == word.length) {
            return true;
        }
        if (row == -1 || col == -1 || row == board.length || col == board[0].length || board[row][col] != word[idx]) {
            return false;
        }

        boolean res = false;
        char temp = board[row][col];
        board[row][col] = '*';
        for (var direction : directions) {
            res |= isValid(board, word, row + direction[0], col + direction[1], idx + 1);
        }
        board[row][col] = temp;
        return res;
    }
}
