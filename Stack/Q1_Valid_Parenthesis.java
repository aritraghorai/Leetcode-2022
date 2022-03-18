package Stack;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:13/03/2022
 ?Program Details:20. Valid Parentheses
 *https://leetcode.com/problems/valid-parentheses/ 
   */
public class Q1_Valid_Parenthesis {
    public boolean isValid(String s) {

        var stack = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else if (!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                    stack.pop();
                } else if (!stack.isEmpty() && stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
