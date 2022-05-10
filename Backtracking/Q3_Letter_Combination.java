package Backtracking;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:09/05/2022
 ?Program Details:17. Letter Combinations of a Phone Number
 *https://leetcode.com/problems/letter-combinations-of-a-phone-number/
   */
public class Q3_Letter_Combination {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        String[] letters = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        var res = helper(digits.toCharArray(), letters, 0);
        return res;
    }

    public List<String> helper(char[] digits, String[] letters, int index) {
        if (index == digits.length) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        var recRes = helper(digits, letters, index + 1);
        int a = Character.getNumericValue(digits[index]);
        var res = new ArrayList<String>();
        for (char ch : letters[a].toCharArray()) {
            for (var str : recRes) {
                res.add(ch + str);
            }
        }
        return res;
    }

}
