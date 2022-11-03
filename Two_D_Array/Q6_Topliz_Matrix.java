package Two_D_Array;

/*
 !Name: Aritra Ghorai
 !Date:31/10/2022
 ?Program Details:766. Toeplitz Matrix
 *https://leetcode.com/problems/toeplitz-matrix/ 
   */
public class Q6_Topliz_Matrix {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
        // int[][] arr = { { 1, 2 }, { 2, 2 } };
        System.out.println(isToeplitzMatrix(arr));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int colm = matrix[0].length - 1;
        for (int i = colm; i >= 0; i--) {
            int ele = matrix[0][i];
            int r = 1;
            for (int j = i + 1; j < matrix[0].length && r < matrix.length; j++) {
                if (ele != matrix[r][j]) {
                    return false;
                }
                r++;
            }
        }
        for (int i = 2; i < matrix.length; i++) {
            int ele = matrix[i][0];
            int col = 1;
            for (int j = i + 1; j < matrix.length && col < matrix[0].length; j++) {
                if (ele != matrix[j][col]) {
                    return false;
                }
                col++;
            }
        }
        return true;
    }
}
