package HashMap;

import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:09/07/2022
 ?Program Details: 
   */
public class Q14_jump_game_4 {
    public static void main(String[] args) {
        int[] nums = { 1, -1, -2, 4, -7, 3 };
        System.out.println(maxResult(nums, 2));
    }

    public static int maxResult(int[] nums, int k) {

        // return helper(nums, k, 0, new Integer[nums.length]);
        // int[] dp = new int[nums.length];
        // dp[nums.length - 1] = nums[nums.length - 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });
        pq.add(new int[] { nums[nums.length - 1], nums.length - 1 });
        int maxScore = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            while (pq.peek()[1] - i > k) {
                pq.poll();
            }
            maxScore = pq.peek()[0] + nums[i];
            pq.offer(new int[] { maxScore, i });
        }
        return maxScore;
    }

    public int helper(int[] nums, int k, int idx, Integer[] dp) {
        if (idx == nums.length - 1) {
            return nums[nums.length - 1];
        }
        if (dp[idx] != null)
            return dp[idx];
        int res = Integer.MIN_VALUE;
        for (int i = idx + 1; i <= Math.min(idx + k, nums.length - 1); i++) {
            res = Math.max(res, helper(nums, k, i, dp) + nums[idx]);
        }
        return dp[idx] = res;
    }
}
