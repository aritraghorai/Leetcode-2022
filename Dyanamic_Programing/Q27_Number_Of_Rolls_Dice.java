package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:02/10/2022
 ?Program Details:1155. Number of Dice Rolls With Target Sum
*https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
   */
public class Q27_Number_Of_Rolls_Dice {

  int mod = (int) (1e9 + 7);

  public int numRollsToTarget(int n, int k, int target) {
    return f(n, k, target, new Integer[n + 1][target + 1]);
  }

  public int f(int n, int k, int target, Integer[][] dp) {
    if (n == 0 && target == 0) {
      return 1;
    }
    if (n == 0 || target == 0) {
      return 0;
    }
    if (dp[n][target] != null) {
      return dp[n][target] % mod;
    }
    int res = 0;
    for (int i = 1; i <= k && target >= i; i++) {
      res += f(n - 1, k, target - i, dp);
    }
    return dp[n][target] = res;
  }
}
