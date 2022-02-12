package String;

import java.util.*;

/*  
 !Name: Aritra Ghorai
 !Date:02/02/2022
 ?Program Details:438. Find All Anagrams in a String
 *https://leetcode.com/problems/find-all-anagrams-in-a-string/ 
   */
public class Q1_Find_All_The_Anagram_In_A_String {
    public List<Integer> findAnagrams(String s, String p) {
        int windowSize = p.length();
        int i = 0, j = 0;
        var map = new HashMap<Character, Integer>();
        for (char ch : p.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int count = map.size();
        var result = new ArrayList<Integer>();
        while (i < s.length() && j < s.length()) {
            if ((j - i + 1) < windowSize) {
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    if (map.get(s.charAt(j)) == 0) {
                        count--;
                    }

                }
                j++;
            } else {

                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    if (map.get(s.charAt(j)) == 0) {
                        count--;
                    }
                }
                j++;
                if (count == 0) {
                    result.add(i);
                }
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if (map.get(s.charAt(i)) == 1) {
                        count++;
                    }
                }
                i++;

            }
        }
        return result;
    }
}
