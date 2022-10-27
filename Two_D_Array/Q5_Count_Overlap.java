package Two_D_Array;

/*
 !Name: Aritra Ghorai
 !Date:27/10/2022
 ?Program Details:835. Image Overlap
 *https://leetcode.com/problems/image-overlap/
   */
public class Q5_Count_Overlap {

    public int largestOverlap(int[][] img1, int[][] img2) {
        int max = 0;
        int n = img1.length;
        int m = img1[0].length;
        for (int rowOff = -n + 1; rowOff < n; rowOff++) {
            for (int colOff = -m + 1; colOff < m; colOff++) {
                int count = countOverlap(img1, img2, rowOff, colOff);
                max = Math.max(count, max);
            }
        }
        return max;
    }

    private int countOverlap(int[][] img1, int[][] img2, int rowOff, int colOff) {
        int count = 0;
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img2.length; j++) {
                int newRow = i + rowOff;
                int newCol = j + colOff;
                if (newRow < 0 || newRow >= img1.length || newCol < 0 || newCol >= img1[0].length) {
                    continue;
                }
                if (img1[i][j] == 1 && img2[newRow][newCol] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
