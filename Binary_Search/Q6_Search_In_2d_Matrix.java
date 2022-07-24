package Binary_Search;

/*
 !Name: Aritra Ghorai
 !Date:24/07/2022
 ?Program Details:240. Search a 2D Matrix II
*https://leetcode.com/problems/search-a-2d-matrix-ii/
   */
public class Q6_Search_In_2d_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
