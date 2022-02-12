package Dyanamic_Programing;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:10/02/2022
 ?Program Details:560. Subarray Sum Equals K
 *https://leetcode.com/problems/subarray-sum-equals-k/
   */
public class Q3_Subarray_Sum_Equal_To_K {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, answer = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                answer += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }
}
