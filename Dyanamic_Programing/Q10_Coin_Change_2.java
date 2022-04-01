package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:01/04/2022
 ?Program Details:518. Coin Change 2
 *https://leetcode.com/problems/coin-change-2/
   */
public class Q10_Coin_Change_2 {
    public int change(int amount, int[] coins) {
        // return helper(amount, coins, 0, new Integer[amount + 1][coins.length + 1]);
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int am = 0; am < amount; am++) {
            for (int index = coins.length - 1; index >= 0; index--) {
                if (am == 0) {
                    dp[am][index] = 1;
                } else {
                    dp[am][index] = dp[am][index + 1];
                    if (am - coins[index] > 0) {
                        dp[am][index] += dp[am - coins[index]][index];
                    }
                }
            }
        }
        return dp[0][amount];
    }

    public int helper(int amount, int[] coins, int i, Integer[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || i == coins.length) {
            return 0;
        }
        if (dp[amount][i] != null)
            return dp[amount][i];
        return dp[amount][i] = helper(amount - coins[i], coins, i, dp) + helper(amount, coins, i + 1, dp);
    }

}
