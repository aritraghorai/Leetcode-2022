package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:10/07/2022
 ?Program Details:746. Min Cost Climbing Stairs
 *https://leetcode.com/problems/min-cost-climbing-stairs/ 
   */
public class Q21_Min_Cost_To_Climb {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[cost.length] = 0;
        dp[cost.length - 1] = cost[cost.length - 1];
        for (int i = cost.length - 2; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);

    }
}
