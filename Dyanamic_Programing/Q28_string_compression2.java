package Dyanamic_Programing;

import java.util.HashMap;
import java.util.Map;

/*
    !Name: Aritra Ghorai
    !Date:15/10/2022
    ?Program Details: 
*/
public class Q28_string_compression2 {

  public int getLengthOfOptimalCompression(String s, int k) {
    Integer[][] dp = new Integer[s.length() + 1][k + 1];
    return f(s.toCharArray(), 0, k, dp);
  }

  public int f(char[] arr, int idx, int k, Integer[][] dp) {
    if (k < 0) {
      return arr.length;
    }
    if (idx + k >= arr.length)
      return 0;
    // *Skip the character
    if (dp[idx][k] != null) {

      return dp[idx][k];
    }

    int ans = f(arr, idx + 1, k - 1, dp);
    int len = 0, same = 0, diff = 0;
    for (int j = idx; j < arr.length && diff <= k; j++) {
      if (arr[idx] == arr[j]) {
        same++;
        if (same <= 2 || same == 10 || same == 100)
          len++;
      } else {
        diff++;
      }
      ans = Math.min(ans, len + f(arr, j + 1, k - diff, dp));
    }
    return dp[idx][k] = ans;

  }

}
