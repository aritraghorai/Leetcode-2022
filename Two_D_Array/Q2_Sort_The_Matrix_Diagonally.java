package Two_D_Array;

/*
 !Name: Aritra Ghorai
 !Date:28/08/2022
 ?Program Details:1329. Sort the Matrix Diagonally
 *1329. Sort the Matrix Diagonally
   */
public class Q2_Sort_The_Matrix_Diagonally {
  public int[][] diagonalSort(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    for (int colm = 0; colm < m; colm++) {
      int nr = 0, nc = colm;
      for (; nr < n && nc < m; nr++, nc++) {
        int swapRowIndex = -1, swapColmIndex = -1;
        int max = mat[nr][nc];
        for (int i = nr + 1, j = nc + 1; i < n && j < m; i++, j++) {
          if (max > mat[i][j]) {
            swapRowIndex = i;
            swapColmIndex = j;
            max = mat[i][j];
          }
        }
        if (swapRowIndex != -1) {
          int temp = mat[swapRowIndex][swapColmIndex];
          mat[swapRowIndex][swapColmIndex] = mat[nr][nc];
          mat[nr][nc] = temp;
        }
      }
    }
    for (int row = 0; row < n; row++) {
      int nr = row, nc = 0;
      for (; nr < n && nc < m; nr++, nc++) {

        int swapRowIndex = -1, swapColmIndex = -1;
        int max = mat[nr][nc];
        for (int i = nr + 1, j = nc + 1; i < n && j < m; i++, j++) {
          if (max > mat[i][j]) {
            swapRowIndex = i;
            swapColmIndex = j;
            max = mat[i][j];
          }
        }
        if (swapRowIndex != -1) {
          int temp = mat[swapRowIndex][swapColmIndex];
          mat[swapRowIndex][swapColmIndex] = mat[nr][nc];
          mat[nr][nc] = temp;
        }
      }
    }
    return mat;
  }
}
