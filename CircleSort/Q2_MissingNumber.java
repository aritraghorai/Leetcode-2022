package CircleSort;

/*
 !Name: Aritra Ghorai
 !Date:28/05/2022
 ?Program Details:268. Missing Number
 *https://leetcode.com/problems/missing-number/
   */
public class Q2_MissingNumber {
  public int missingNumber(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      int actualLocation = nums[i];
      if (actualLocation >= 0 && actualLocation < nums.length && actualLocation != i) {
        int temp = nums[actualLocation];
        nums[actualLocation] = nums[i];
        nums[i] = temp;
      } else {
        i++;
      }
    }
    for (i = 0; i < nums.length; i++) {
      if (nums[i] != i) {
        return i;
      }
    }
    return -1;
  }
}
