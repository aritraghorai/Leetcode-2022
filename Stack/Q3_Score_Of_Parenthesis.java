package Stack;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:17/03/2022
 ?Program Details:856. Score of Parentheses
 *https://leetcode.com/problems/score-of-parentheses/ 
   */
public class Q3_Score_Of_Parenthesis {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()(()))"));
    }

    public static int scoreOfParentheses(String s) {
        char[] sArray = s.toCharArray();
        int ans = 0, curr = 0;
        var stack = new LinkedList<ParenthesesPair>();
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == '(') {
                stack.push(new Stack.ParenthesesPair(i, 0));
            } else {
                if (stack.peek().index + 1 == i) {
                    curr += 1;
                } else {
                    curr = stack.peek().value * 2;
                }
                stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek().value += curr;
                    curr = 0;
                }
            }
            if (stack.isEmpty()) {
                ans += curr;
                curr = 0;
            }
        }
        return ans;
    }
}

class ParenthesesPair {
    public int index;
    public int value;

    public ParenthesesPair(int i, int value) {
        index = i;
        this.value = value;
    }
}
