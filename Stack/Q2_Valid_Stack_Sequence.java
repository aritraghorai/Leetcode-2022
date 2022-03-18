package Stack;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:16/03/2022
 ?Program Details:946. Validate Stack Sequences
 *https://leetcode.com/problems/validate-stack-sequences/
   */
public class Q2_Valid_Stack_Sequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length)
            return false;
        var stack = new LinkedList<Integer>();
        int j = 0;
        for (int i : pushed) {
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
            stack.push(i);
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
