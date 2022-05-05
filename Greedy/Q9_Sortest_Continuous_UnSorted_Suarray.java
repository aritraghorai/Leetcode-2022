package Greedy;

/*
 !Name: Aritra Ghorai
 !Date:03/05/2022
 ?Program Details:581. Shortest Unsorted Continuous Subarray
 *https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
   */
public class Q9_Sortest_Continuous_UnSorted_Suarray {
    public int findUnsortedSubarray(int[] nums) {
        int right = 0, left = nums.length - 1, max = nums[0], min = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max > nums[i]) {
                right = i;
            }
        }
        if (right == 0) {
            return 0;
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            min = Math.min(min, nums[j]);
            if (min < nums[j]) {
                left = j;
            }
        }
        if (left == nums.length - 1) {
            return 0;
        }
        return right - left + 1;
    }
}
