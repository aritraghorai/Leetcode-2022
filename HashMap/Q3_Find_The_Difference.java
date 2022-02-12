package HashMap;

/*
 !Name: Aritra Ghorai
 !Date:07/02/2022
 ?Program Details:389. Find the Difference
 *https://leetcode.com/problems/find-the-difference/
   */
public class Q3_Find_The_Difference {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        int[] freq1 = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] + 1 == freq1[i]) {
                return (char) ('a' + i);
            }
        }
        return 'a';
    }
}
