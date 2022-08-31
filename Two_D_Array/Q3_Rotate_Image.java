package Two_D_Array;

/*
 !Name: Aritra Ghorai
 !Date:30/08/2022
 ?Program Details:48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
   */
public class Q3_Rotate_Image {
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] res = new int[n][m];
        for (int col = 0; col < m; col++) {
            for (int row = n - 1; row >= 0; row--) {
                res[col][n - 1 - row] = matrix[row][col];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }
}
