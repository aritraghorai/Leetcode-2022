package Sliding_Window;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:05/02/2023
 ?Program Details:438. Find All Anagrams in a String
 *https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
   */
public class Q8_Find_All_Anagram_In_String {
    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = map.size();
        int window_size = p.length();
        int i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (j < s.length()) {
            if (j - i + 1 < window_size) {
                char ch = s.charAt(j++);
                if (map.containsKey(ch)) {
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                    if (map.get(ch) == 0) {
                        count--;
                    }
                }
            } else {
                char ch = s.charAt(j++);
                if (map.containsKey(ch)) {
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                    if (map.get(ch) == 0) {
                        count--;
                    }
                }
                if (count == 0) {
                    res.add(i);
                }
                char ch2 = s.charAt(i++);
                if (map.containsKey(ch2)) {
                    map.put(ch2, map.getOrDefault(ch2, 0) + 1);
                    if (map.get(ch2) == 1) {
                        count++;
                    }
                }
            }
        }
        return res;
    }
}
