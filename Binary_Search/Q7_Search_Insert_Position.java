package Binary_Search;

/*
 !Name: Aritra Ghorai
 !Date:20/02/2023
 ?Program Details:35. Search Insert Position
 *https://leetcode.com/problems/search-insert-position/
   */
public class Q7_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

}
