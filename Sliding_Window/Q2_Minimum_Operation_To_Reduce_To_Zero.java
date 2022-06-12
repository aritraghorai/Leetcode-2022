package Sliding_Window;

/*
 !Name: Aritra Ghorai
 !Date:11/06/2022
 ?Program Details:1658. Minimum Operations to Reduce X to Zero
 *https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/ 
   */
public class Q2_Minimum_Operation_To_Reduce_To_Zero {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        int subArraySum = sum - x;
        if (subArraySum < 0) {
            return -1;
        }
        int max = -1;
        int left = 0;
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > subArraySum) {
                sum -= nums[left++];
            }
            if (sum == subArraySum) {
                max = Math.max(max, i - left + 1);
            }
        }
        return max == -1 ? -1 : nums.length - max;

    }
}
