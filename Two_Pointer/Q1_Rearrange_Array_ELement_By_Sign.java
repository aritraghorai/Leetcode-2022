package Two_Pointer;

/*
 !Name: Aritra Ghorai
 !Date:29/01/2022
 ?Program Details:2149. Rearrange Array Elements by Sign
 *https://leetcode.com/problems/rearrange-array-elements-by-sign/ 
   */
public class Q1_Rearrange_Array_ELement_By_Sign {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int even = 0, odd = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[even] = nums[i];
                even += 2;
            } else {
                ans[odd] = nums[i];
                odd += 2;
            }
        }
        return ans;
    }

}
