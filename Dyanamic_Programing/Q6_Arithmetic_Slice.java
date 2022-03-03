package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:03/03/2022
 ?Program Details:413. Arithmetic Slices
 *https://leetcode.com/problems/arithmetic-slices/
   */
public class Q6_Arithmetic_Slice {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0, sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                count += 1;
                sum += count;
            } else {
                count = 0;
            }
        }
        return sum;
    }
}
