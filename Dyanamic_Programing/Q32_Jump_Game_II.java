package Dyanamic_Programing;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:08/02/2023
 ?Program Details:45. Jump Game II
 *https://leetcode.com/problems/jump-game-ii/
   */
public class Q32_Jump_Game_II {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 0, 1, 4 };
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= Math.min(nums.length - 1, i + nums[i]); j++) {
                min = Math.min(dp[j], min);
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            } else {
                dp[i] = Integer.MAX_VALUE;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];

    }
}
