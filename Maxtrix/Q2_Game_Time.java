package Maxtrix;

/*
 !Name: Aritra Ghorai
 !Date:12/04/2022
 ?Program Details:289. Game of Life
 *https://leetcode.com/problems/game-of-life/
   */
public class Q2_Game_Time {

    int[][] neighbours = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

    public void gameOfLife(int[][] board) {
        playGame(board);
        updateGame(board);
    }

    private void updateGame(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private void playGame(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int lifeNeightbour = getNeighBour(board, i, j);
                if (board[i][j] == 0 && lifeNeightbour == 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && (lifeNeightbour == 2 || lifeNeightbour == 3)) {
                    board[i][j] = 3;
                }
            }
        }
    }

    private int getNeighBour(int[][] board, int row, int colm) {
        int lifeNeightbour = 0;
        for (int[] neighbour : neighbours) {
            int newRow = row - neighbour[0];
            int newColm = colm - neighbour[1];
            if (isValid(board, newRow, newColm)) {
                lifeNeightbour += (board[newRow][newColm] & 1);
            }
        }
        return lifeNeightbour;
    }

    private boolean isValid(int[][] board, int newRow, int newColm) {
        return board.length > newRow && board[0].length > newColm && newColm >= 0 && newRow >= 0;
    }

}
