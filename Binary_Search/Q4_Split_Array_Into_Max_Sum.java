package Binary_Search;

/*
 !Name: Aritra Ghorai
 !Date:31/03/2022
 ?Program Details:410. Split Array Largest Sum
 *https://leetcode.com/problems/split-array-largest-sum/ 
   */
public class Q4_Split_Array_Into_Max_Sum {
  public int splitArray(int[] nums, int m) {
    int start = 0, end = 0;
    for (int i = 0; i < nums.length; i++) {
      start = Math.max(start, nums[i]);
      end += nums[i];
    }

    // *Binary Search
    while (start < end) {
      // *try mid as potential ans
      int mid = start + ((end - start) >> 1);
      // *How many pices you are going to divide
      int sum = 0;
      int pices = 1;
      for (int num : nums) {
        if (sum + num > mid) {
          pices++;
          sum = num;
        } else {
          sum += num;
        }
      }
      if (pices <= m) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return end;
  }
}
