package Array;

/*
 !Name: Aritra Ghorai
 !Date:30/01/2022
 ?Program Details:189. Rotate Array 
 *https://leetcode.com/problems/rotate-array/
   */
public class Q1_Rotate_The_Array {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}
