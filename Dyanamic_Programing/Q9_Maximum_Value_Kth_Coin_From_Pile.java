package Dyanamic_Programing;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:01/04/2022
 ?Program Details:2218. Maximum Value of K Coins From Piles
 *https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
   */
public class Q9_Maximum_Value_Kth_Coin_From_Pile {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        return helper(piles, 0, k, new Integer[piles.size() + 1][k + 1]);
    }

    public int helper(List<List<Integer>> piles, int index, int k, Integer[][] dp) {
        if (k == 0 || index == piles.size())
            return 0;
        if (dp[index][k] != null)
            return dp[index][k];
        int res = 0;

        // *Exclude call
        res = Math.max(res, helper(piles, index + 1, k, dp));
        // *Include call
        int sumOfElement = 0;
        for (int i = 0; i < Math.min(k, piles.get(index).size()); i++) {
            sumOfElement += piles.get(index).get(i);
            res = Math.max(res, sumOfElement + helper(piles, index + 1, k - 1 - i, dp));
        }
        return dp[index][k] = res;
    }

}
