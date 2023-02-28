package Binary_Search;

/*
 !Name: Aritra Ghorai
 !Date:21/02/2023
 ?Program Details:540. Single Element in a Sorted Array
 *https://leetcode.com/problems/single-element-in-a-sorted-array/
   */
public class Q8_Single_Element_In_Sorted_Array {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            int num = mid % 2 == 0 ? mid + 1 : mid - 1;
            if (nums[mid] == nums[num])
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low];
    }
}
