package Stack;

import java.util.Arrays;
import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:30/11/2022
 ?Program Details: 503. Next Greater Element II
 *https://leetcode.com/problems/next-greater-element-ii/
   */
public class Q16_Next_Grater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int si = n * 2 - 1;
        int k = n - 1;
        int[] result = new int[n];
        LinkedList<Integer> stack = new LinkedList<>();
        Arrays.fill(result, -1);
        while (si >= 0) {
            int idx = si % n;
            while (!stack.isEmpty() && stack.peek() <= nums[idx]) {
                stack.pop();
            }
            if (si < n) {
                if (!stack.isEmpty()) {
                    result[k] = stack.peek();
                }
                k--;
            }
            stack.push(nums[idx]);
            si--;
        }
        return result;
    }
}
