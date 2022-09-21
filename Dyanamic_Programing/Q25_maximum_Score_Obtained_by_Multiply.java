package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:16/09/2022
 ?Program Details: 1770. Maximum Score from Performing Multiplication Operations
 *https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
   */
public class Q25_maximum_Score_Obtained_by_Multiply {
    public int maximumScore(int[] nums, int[] multipliers) {
        // return f(nums, multipliers, 0, 0, nums.length - 1,
        // new Integer[multipliers.length + 1][nums.length][nums.length]);
        return f(nums, multipliers, 0, 0, new Integer[multipliers.length + 1][nums.length]);
    }

    // *Using 3d dp */
    public int f(int[] nums, int[] mul, int idx, int i, int j, Integer[][][] dp) {
        if (idx == mul.length) {
            return 0;
        }
        if (dp[idx][i][j] != null) {
            return dp[idx][i][j];
        }
        // *If we choise the left part of the array */
        int left = mul[idx] * nums[i] + f(nums, mul, idx + 1, i + 1, j, dp);
        // *If we choise the right part of the array */
        int right = mul[idx] * nums[j] + f(nums, mul, idx + 1, i, j - 1, dp);
        return dp[idx][i][j] = Math.max(left, right);
    }

    // *using 2d Dp */
    public int f(int[] nums, int[] mul, int idx, int j, Integer[][] dp) {
        if (idx == mul.length) {
            return 0;
        }
        if (dp[idx][j] != null) {
            return 0;
        }
        // *Left Choise */
        int left = mul[idx] * nums[j] + f(nums, mul, idx + 1, j + 1, dp);
        // *Right Choise */
        int right = mul[idx] * nums[nums.length - 1 - j + idx] + f(nums, mul, idx + 1, j, dp);

        return dp[idx][j] = Math.max(left, right);
    }
}
