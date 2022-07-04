package Greedy;

/*
 !Name: Aritra Ghorai
 !Date:03/07/2022
 ?Program Details:376. Wiggle Subsequence
*https://leetcode.com/problems/wiggle-subsequence/
   */
public class Q11_Wiggle_Subsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0)
            return 0;
        int posi = 1, neg = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                posi = neg + 1;
            } else if (nums[i] < nums[i + 1]) {
                neg = posi + 1;
            }
        }
        return Math.max(posi, neg);
    }
}
