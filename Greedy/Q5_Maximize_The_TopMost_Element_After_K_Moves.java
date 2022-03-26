package Greedy;

/*
 !Name: Aritra Ghorai
 !Date:23/03/2022
 ?Program Details:2202. Maximize the Topmost Element After K Moves
 *https://leetcode.com/problems/maximize-the-topmost-element-after-k-moves/ 
   */
public class Q5_Maximize_The_TopMost_Element_After_K_Moves {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            if (n >= 1) {
                return nums[0];
            }
            return -1;
        }
        if (k == 1) {
            if (n >= 2) {
                return nums[1];
            }
            return -1;
        }
        if (n == 1) {
            if (k % 2 == 0) {
                return nums[0];
            }
            return -1;
        }
        int maxi = 0;
        for (int i = 0; i < Math.min(k - 1, n); i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        if (k < n) {
            maxi = Math.max(maxi, nums[k]);
        }
        return maxi;
    }
}
