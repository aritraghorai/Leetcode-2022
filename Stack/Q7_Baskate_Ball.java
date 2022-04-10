package Stack;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:10/04/2022
 ?Program Details:682. Baseball Game
 *https://leetcode.com/problems/baseball-game/
   */
public class Q7_Baskate_Ball {
    public static void main(String[] args) {
        String[] ops = { "5", "-2", "4", "C", "D", "9", "+", "+" };
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops) {
        var stack = new LinkedList<String>();
        for (String s : ops) {
            if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                stack.push(new String(Integer.parseInt(stack.peek()) * 2 + ""));
            } else if (s.equals("+")) {
                String temp1 = stack.pop();
                String temp2 = stack.pop();
                stack.push(temp2);
                stack.push(temp1);
                stack.push(new String((Integer.parseInt(temp1) + Integer.parseInt(temp2)) + ""));
            } else {
                stack.push(s);
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += Integer.parseInt(stack.pop());
        }
        return res;
    }
}
