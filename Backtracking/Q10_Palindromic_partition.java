package Backtracking;

import java.util.*;

public class Q10_Palindromic_partition {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        helper(new ArrayList<>(), s);
        return res;
    }

    private void helper(List<String> temp, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            if (palindrome(s1)) {
                temp.add(s1);
                helper(temp, s2);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean palindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
