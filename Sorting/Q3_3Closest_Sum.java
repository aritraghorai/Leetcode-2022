package Sorting;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:08/10/2022
 ?Program Details:16. 3Sum Closest
*https://leetcode.com/problems/3sum-closest/description/
   */
public class Q3_3Closest_Sum {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int cloestSum = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < diff) {
                    cloestSum = sum;
                    diff = Math.abs(sum - target);
                }
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return cloestSum;
    }
}
