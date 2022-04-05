package String;

/*
 !Name: Aritra Ghorai
 !Date:02/04/2022
 ?Program Details:680. Valid Palindrome II
 *https://leetcode.com/problems/valid-palindrome-ii/ 
   */
public class Q9_Valid_Palindrome_2 {

    public boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1, true);
    }

    public boolean helper(String s, int i, int j, boolean temp) {
        if (i >= j)
            return true;
        if (s.charAt(i) == s.charAt(j)) {
            return helper(s, i + 1, j - 1, temp);
        } else if (temp) {
            return helper(s, i + 1, j, false) || helper(s, i, j - 1, false);
        }
        return false;
    }
}
