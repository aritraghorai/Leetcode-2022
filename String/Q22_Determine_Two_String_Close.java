package String;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:02/12/2022
 ?Program Details:1657. Determine if Two Strings Are Close
 *https://leetcode.com/problems/determine-if-two-strings-are-close/
   */
public class Q22_Determine_Two_String_Close {
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        char[] arr = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            freq1[arr[i] - 'a']++;
            freq2[arr2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq1[i] == 0 && freq2[i] != 0) {
                return false;
            }
            if (freq1[i] != 0 && freq2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}
