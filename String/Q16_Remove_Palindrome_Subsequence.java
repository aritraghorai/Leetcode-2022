package String;

/*
 !Name: Aritra Ghorai
 !Date:08/06/2022
 ?Program Details:1332. Remove Palindromic Subsequences
 *https://leetcode.com/problems/remove-palindromic-subsequences/
   */
public class Q16_Remove_Palindrome_Subsequence {
    public int removePalindromeSub(String s) {
        if (s.length() == 0)
            return 0;
        if (isPalindrome(s)) {
            return 1;
        }
        return 2;
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

}
