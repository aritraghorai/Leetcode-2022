package HashMap;

/*
 !Name: Aritra Ghorai
 !Date:23/11/2022
 ?Program Details:36. Valid Sudoku 
 *https://leetcode.com/problems/valid-sudoku/
   */
public class Q25_Valid_Sudaku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] ok = new boolean[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int val = board[i][j];
                if (ok[i][val - '0' - 1]) {
                    return false;
                } else {
                    ok[i][val - '0' - 1] = true;
                }
            }
        }
        boolean[][] ok1 = new boolean[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int val = board[j][i];
                if (ok1[val - '0' - 1][i]) {
                    return false;
                } else {
                    ok1[val - '0' - 1][i] = true;
                }
            }
        }
        return true;
    }
}
