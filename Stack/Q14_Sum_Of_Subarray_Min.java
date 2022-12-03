package Stack;

import java.util.Stack;

/*
 !Name: Aritra Ghorai
 !Date:30/11/2022
 ?Program Details:907. Sum of Subarray Minimums
 *https://leetcode.com/problems/sum-of-subarray-minimums/
   */
public class Q14_Sum_Of_Subarray_Min {
    int mod = (int) (1e9 + 7);

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] leftSmaller = new int[arr.length];
        int[] rightSmaller = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        // *For find the left smaller corosponds to each element */
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftSmaller[i] = 0;
            } else {
                leftSmaller[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        stack.clear();
        // *Find right smaller corosponds to each element */
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSmaller[i] = n - 1;
            } else {
                rightSmaller[i] = stack.peek() - 1;
            }
            stack.push(i);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            int left = i - leftSmaller[i] + 1;
            int right = rightSmaller[i] - i + 1;
            long add = (long) (left) * (long) (right) * (long) (arr[i]);
            res += add;
            res %= mod;
        }
        return (int) res;
    }
}
