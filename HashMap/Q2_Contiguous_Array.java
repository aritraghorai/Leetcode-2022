package HashMap;

import java.util.HashMap;

/*
 !Name: Aritra Ghorai
 !Date:04/02/2022
 ?Program Details: 525. Contiguous Array
 *https://leetcode.com/problems/contiguous-array/
   */
public class Q2_Contiguous_Array {
  public int findMaxLength(int[] nums) {
    int max = 0;
    int sum = 0;
    var map = new HashMap<Integer, Integer>();
    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      sum = nums[i] == 0 ? sum - 1 : sum + 1;
      if (map.containsKey(sum)) {
        max = Math.max(max, i - map.get(sum));
      } else {
        map.put(sum, i);
      }
    }
    return max;
  }
}
