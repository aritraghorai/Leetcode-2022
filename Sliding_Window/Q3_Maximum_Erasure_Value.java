package Sliding_Window;

import java.util.HashMap;

/*
 !Name: Aritra Ghorai
 !Date:12/06/2022
 ?Program Details:1695. Maximum Erasure Value 
 *https://leetcode.com/problems/maximum-erasure-value/
   */
public class Q3_Maximum_Erasure_Value {
  public int maximumUniqueSubarray(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int left = 0;
    int max = 1;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      while (map.size() != i - left + 1) {
        if (map.get(nums[left]) == 1) {
          map.remove(nums[left]);
        } else {
          map.put(nums[left], map.get(nums[left]) - 1);
        }
        sum -= nums[left];
        left++;
      }
      max = Math.max(sum, max);
    }
    return max;
  }
}
