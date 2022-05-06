package Stack;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:06/05/2022
 ?Program Details:1047. Remove All Adjacent Duplicates In String
 *https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
   */
public class Q8_Remove_All_Duplicate_Adjacent {
    public String removeDuplicates(String s) {
        LinkedList<Character> st = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == c) {
                st.pop();
            }
            st.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
