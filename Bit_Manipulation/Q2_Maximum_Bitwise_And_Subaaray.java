package Bit_Manipulation;

/*
 !Name: Aritra Ghorai
 !Date:25/09/2022
 ?Program Details:2419. Longest Subarray With Maximum Bitwise AND
*https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/
   */
public class Q2_Maximum_Bitwise_And_Subaaray {
    public int longestSubarray(int[] nums) {
        int max = 1, count = 0, maxEle = 0;
        for (int i : nums) {
            maxEle = Math.max(maxEle, i);
        }
        for (int i : nums) {
            if (maxEle == i) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return max;
    }
}
