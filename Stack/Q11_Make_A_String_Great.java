package Stack;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:08/11/2022
 ?Program Details:1544. Make The String Great
 *https://leetcode.com/problems/make-the-string-great/
   */
public class Q11_Make_A_String_Great {
    public static void main(String[] args) {
        System.out.println(makeGood("abBAcC"));
    }

    public static String makeGood(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty() && (Character.isUpperCase(arr[i]) && Character.toLowerCase(arr[i]) == stack.peek())
                    || (Character.isLowerCase(arr[i]) && Character.toUpperCase(arr[i]) == stack.peek())) {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}
