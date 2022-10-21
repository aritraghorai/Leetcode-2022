package Array;

/*
 !Name: Aritra Ghorai
 !Date:07/06/2022
 ?Program Details:88. Merge Sorted Array
*https://leetcode.com/problems/merge-sorted-array/
   */
public class Q10_Merge_Two_Sorted_Array {
  public void merge(int[] nums1, int m, int[] nums2, int n) {  
    int i = m - 1;
    int j = n - 1;
    int k = nums1.length - 1;
    while (i >= 0 && k >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[k] = nums1[i];
        i--;
        k--;
      } else if (nums1[i] < nums2[j]) {
        nums1[k] = nums2[j];
        k--;
        j--;
      } else {
        nums1[k] = nums1[i];
        k--;
        nums1[k] = nums2[j];
        k--;
        i--;
        j--;
      }
    }
    while (j >= 0) {
      nums1[k] = nums2[j];
      k--;
      j--;
    }

  }
}
