package Maxtrix;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:13/04/2022
 ?Program Details:59. Spiral Matrix II
*https://leetcode.com/problems/spiral-matrix-ii/
   */
public class Q3_Spritual_Matrix {
    public static void main(String[] args) {
        var res = generateMatrix(1);
        for (int[] a : res) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int numberOfElement = n * n;
        int direction = 1;
        int i = 0, j = 0;
        int endRow = n - 1, endColm = n - 1;
        int number = 1;
        while (numberOfElement >= 0 && i <= endRow && j <= endColm) {
            if (direction == 1) {
                for (int colm = j; colm <= endColm; colm++) {
                    res[i][colm] = number;
                    number++;
                    numberOfElement--;
                }
                direction = 2;
                i++;
            }
            if (direction == 2) {
                for (int row = i; row <= endRow; row++) {
                    res[row][endColm] = number;
                    number++;
                    numberOfElement--;
                }
                direction = 3;
                endColm--;
            }
            if (direction == 3) {
                for (int colm = endColm; colm >= j; colm--) {
                    res[endRow][colm] = number;
                    number++;
                    numberOfElement--;
                }
                direction = 4;
                endRow--;
            }
            if (direction == 4) {
                for (int row = endRow; row >= i; row--) {
                    res[row][j] = number;
                    number++;
                    numberOfElement--;
                }
                direction = 1;
                j++;
            }
        }
        return res;
    }
}
