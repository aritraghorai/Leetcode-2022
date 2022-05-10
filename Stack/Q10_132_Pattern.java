package Stack;

import java.util.Stack;

/*
 !Name: Aritra Ghorai
 !Date:07/05/2022
 ?Program Details:456. 132 Pattern
 *https://leetcode.com/problems/132-pattern/ 
   */
public class Q10_132_Pattern {
    public boolean find132pattern(int[] nums) {
        // *Finding The Minumum Array
        int[] minArray = new int[nums.length];
        minArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minArray[i] = Math.min(nums[i], minArray[i - 1]);
        }
        Stack<Integer> st = new Stack<>();
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!st.isEmpty() && minArray[j] >= st.peek())
                st.pop();
            if (!st.isEmpty() && st.peek() > minArray[j] && nums[j] > st.peek())
                return true;
            st.push(nums[j]);
        }
        return false;
    }
}
