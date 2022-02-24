package Array;

/*
 !Name: Aritra Ghorai
 !Date:21/02/2022
 ?Program Details:169. Majority Element
 *https://leetcode.com/problems/majority-element/ 
   */
public class Q6_Majority_Element {
    public int majorityElement(int[] nums) {
        int ansIndex = 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            count = nums[ansIndex] == nums[i] ? count + 1 : count - 1;
            if (count < 0) {
                count = 0;
                ansIndex = i;
            }
        }
        return nums[ansIndex];
    }
}
