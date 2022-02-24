package String;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:18/02/2022
 ?Program Details:402. Remove K Digits
 *https://leetcode.com/problems/remove-k-digits/ 
   */
public class Q3_Remove_K_Digit {
    public static void main(String[] args) {
        String num = "112";
        System.out.println(removeKdigits(num, 1));
    }

    public static String removeKdigits(String num, int k) {
        var st = new LinkedList<Character>();
        for (char c : num.toCharArray()) {
            while (!st.isEmpty() && st.peek() > c && k > 0) {
                st.pop();
                k--;
            }
            st.push(c);
        }
        while (!st.isEmpty() && k-- > 0) {
            st.pop();
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            char c = st.peekLast();
            if (c != '0')
                break;
            else
                st.removeLast();
        }
        while (!st.isEmpty()) {
            ans.append(st.removeLast());
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
