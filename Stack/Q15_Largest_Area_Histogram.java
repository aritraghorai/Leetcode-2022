package Stack;

import java.util.Stack;

public class Q15_Largest_Area_Histogram {
    public static void main(String[] args) {
        // int[] arr = { 2, 1, 5, 6, 2, 3 };
        int[] arr = { 1 };
        System.out.println(largestRectangleArea(arr));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmaller = new int[heights.length];
        int[] rightSmaller = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        // *For find the left smaller corosponds to each element */
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
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
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSmaller[i] = n - 1;
            } else {
                rightSmaller[i] = stack.peek() - 1;
            }
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int diff = rightSmaller[i] - leftSmaller[i] + 1;
            if (diff <= 0) {
                res = Math.max(res, heights[i]);
            } else {
                res = Math.max(res, heights[i] * diff);
            }
        }
        return res;
    }
}
