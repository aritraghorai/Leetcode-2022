package Binary_Search;

/*
 !Name: Aritra Ghorai
 !Date:28/03/2022
 ?Program Details:81. Search in Rotated Sorted Array II
 *https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
   */
public class Q2_Search_In_Roated_Sorted_Array_2 {
    public static void main(String[] args) {
        int[] nums = { 1, 3 };
        System.out.println(search(nums, 2));
    }

    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target)
                return true;
            // *Special Case
            if (nums[low] == nums[mid] && nums[high] == nums[mid]) {
                return linierSearch(nums, target);
            }
            // *it means mid in the first half
            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                // *It means mid in second half
            } else {
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static boolean linierSearch(int[] nums, int target) {
        for (int i : nums) {
            if (i == target)
                return true;
        }
        return false;
    }
}
