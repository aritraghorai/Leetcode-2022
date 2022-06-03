package Design_DS;

/*
 !Name: Aritra Ghorai
 !Date:03/06/2022
 ?Program Details:304. Range Sum Query 2D - Immutable
 *https://leetcode.com/problems/range-sum-query-2d-immutable/
   */
public class Q7_Range_Sum_Query {

}

class NumMatrix {
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        // *Colm Sum
        for (int row = 0; row < matrix.length; row++) {
            for (int colm = 1; colm < matrix[0].length; colm++) {
                matrix[row][colm] += matrix[row][colm - 1];
            }
        }
        // * Row Sum
        for (int row = 1; row < matrix.length; row++) {
            for (int colm = 0; colm < matrix[0].length; colm++) {
                matrix[row][colm] += matrix[row - 1][colm];
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = this.matrix[row2][col2];
        int extra = (col1 != 0 ? this.matrix[row2][col1 - 1]
                : 0)
                + (row1 != 0 ? this.matrix[row1 - 1][col2]
                        : 0)
                - ((row1 != 0 && col1 != 0) ? this.matrix[row1 - 1][col1 - 1] : 0);
        return total - extra;
    }

}
