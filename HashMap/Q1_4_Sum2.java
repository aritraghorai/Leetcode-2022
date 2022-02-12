package HashMap;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:03/02/2022
 ?Program Details:454. 4Sum II
*https://leetcode.com/problems/4sum-ii/
   */
public class Q1_4_Sum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        var map = new HashMap<Integer, Integer>();
        for (int i : nums4) {
            for (int j : nums3) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        for (int a : nums1) {
            for (int b : nums2) {
                if (map.containsKey(-(a + b))) {
                    count += map.get(-(a + b));
                }
            }
        }
        return count;

    }
}
