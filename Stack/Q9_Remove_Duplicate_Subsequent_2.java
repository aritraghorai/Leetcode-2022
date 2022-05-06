package Stack;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:06/05/2022
 ?Program Details:1209. Remove All Adjacent Duplicates in String II
*https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
   */
public class Q9_Remove_Duplicate_Subsequent_2 {
    public String removeDuplicates(String s, int k) {
        Stack<pair> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek().ch == c) {
                if (st.peek().count == k - 1) {
                    st.pop();
                } else {
                    st.peek().count += 1;
                }
            } else {
                st.push(new pair(c, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            var rp = st.pop();
            sb.append(String.join("", Collections.nCopies(rp.count, new String(rp.ch + ""))));
        }
        return sb.reverse().toString();
    }
}

class pair {
    char ch;
    int count;

    pair(char c, int co) {
        ch = c;
        count = co;
    }
}
