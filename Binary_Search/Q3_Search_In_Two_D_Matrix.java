package Binary_Search;

/*
 !Name: Aritra Ghorai
 !Date:30/03/2022
 ?Program Details:74. Search a 2D Matrix
 *https://leetcode.com/problems/search-a-2d-matrix/
   */
public class Q3_Search_In_Two_D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target) {
                row = i;
                break;
            }
        }
        int low = 0, high = matrix[0].length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
