package Array;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:30/06/2022
 ?Program Details:462. Minimum Moves to Equal Array Elements II
*https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/ 
   */
public class Q13_Minimum_Moves_Equal_Array_Element {
    public int minMoves2(int[] nums) {
        // long min = Long.MAX_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        // long temp = 0;
        // for (int j = 0; j < nums.length; j++) {
        // temp += Math.abs(nums[i] - nums[j]);
        // }
        // min = Math.min(min, temp);
        // }
        // return (int) min;
        Arrays.sort(nums);
        int median = nums[nums.length % 2 == 0 ? (nums.length / 2) - 1 : nums.length / 2];
        int diff = 0;
        for (int num : nums) {
            diff += Math.abs(num - median);
        }
        return diff;
    }
}
