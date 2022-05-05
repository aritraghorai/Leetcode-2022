package String;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:01/05/2022
 ?Program Details:844. Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/
   */
public class Q13_Backspeace_String_Match {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        var string1S = new LinkedList<Character>();
        var string2S = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!string1S.isEmpty())
                    string1S.pop();
            } else {
                string1S.push(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!string2S.isEmpty())
                    string2S.pop();
            } else {
                string2S.push(t.charAt(i));
            }
        }
        if (string1S.size() != string2S.size()) {
            return false;
        }
        while (!string1S.isEmpty()) {
            if (string1S.pop() != string2S.pop()) {
                return false;
            }
        }
        return true;
    }
}
