package Sliding_Window;

import java.util.HashMap;

/*
 !Name: Aritra Ghorai
 !Date:04/02/2023
 ?Program Details:567. Permutation in String
 *https://leetcode.com/problems/permutation-in-string/
   */
public class Q7_Permutation_Of_A_String {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int i = 0, j = 0;
        int count = map.size();
        int size = s2.length();
        while (j < size && i < size) {
            if (j - i + 1 < s1.length()) {
                char ch = s2.charAt(j);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) {
                        count--;
                    }
                }
                j++;
            } else {
                char ch = s2.charAt(j);
                if (map.containsKey(ch)) {
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                    if (map.get(ch) == 0) {
                        count--;
                    }
                }
                j++;
                if (count == 0) {
                    return true;
                }
                char ch2 = s2.charAt(i);
                if (map.containsKey(ch2)) {
                    map.put(ch2, map.getOrDefault(ch2, 0) + 1);
                    if (map.get(ch2) == 1) {
                        count++;
                    }
                }
                i++;
            }

        }
        return false;
    }
}
