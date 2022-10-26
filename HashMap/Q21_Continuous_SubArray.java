package HashMap;

import java.util.HashMap;

/*
 !Name: Aritra Ghorai
 !Date:26/10/2022
 ?Program Details: 523. Continuous Subarray Sum
 *https://leetcode.com/problems/continuous-subarray-sum/description/
   */
public class Q21_Continuous_SubArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 12 };
        System.out.println(checkSubarraySum(nums, 6));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> set = new HashMap<>();
        set.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int reminder = sum % k;
            if (set.containsKey(reminder) && i - set.get(reminder) >= 2) {
                return true;
            } else if (!set.containsKey(reminder)) {
                set.put(reminder, i);
            }
        }
        return false;
    }
}
