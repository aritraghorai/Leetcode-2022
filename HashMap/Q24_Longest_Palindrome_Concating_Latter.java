package HashMap;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:03/11/2022
 ?Program Details:2131. Longest Palindrome by Concatenating Two Letter Words 
 *https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
   */
public class Q24_Longest_Palindrome_Concating_Latter {
    public static void main(String[] args) {
        String[] words = { "cc", "ll", "xx" };
        System.out.println(longestPalindrome(words));
    }

    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int length = 0;
        for (String s : words) {
            String reverse = new StringBuilder(s).reverse().toString();
            if (map.containsKey(reverse)) {
                length += 4;
                map.put(reverse, map.get(reverse) - 1);
                if (map.get(reverse) == 0) {
                    map.remove(reverse);
                }
            } else
                map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : map.keySet()) {
            String reverse = new StringBuilder(s).reverse().toString();
            if (reverse.equals(s)) {
                length += 2;
                break;
            }
        }
        return length;
    }
}
