package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:22/05/2022
 ?Program Details:647. Palindromic Substrings
 *https://leetcode.com/problems/palindromic-substrings/ 
   */
public class Q15_Palindromic_Substring {
  public int countSubstrings(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    int count = 0;
    for (int gap = 0; gap < s.length(); gap++) {
      for (int row = 0; row < s.length() - gap; row++) {
        int colm = row + gap;
        if (gap == 0) {
          dp[row][colm] = true;
        } else if (gap == 1) {
          if (s.charAt(row) == s.charAt(colm)) {
            dp[row][colm] = true;
          }
        } else {
          if (s.charAt(row) == s.charAt(colm) && dp[row + 1][colm - 1]) {
            dp[row][colm] = true;
          }
        }
        if (dp[row][colm])
          count++;
      }
    }
    return count;
  }
}
