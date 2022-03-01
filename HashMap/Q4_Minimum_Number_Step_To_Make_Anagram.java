package HashMap;

/*
 !Name: Aritra Ghorai
 !Date:27/02/2022
 ?Program Details:2186. Minimum Number of Steps to Make Two Strings Anagram II
 *https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/
   */
public class Q4_Minimum_Number_Step_To_Make_Anagram {
    public int minSteps(String s, String t) {
        int[] arr = new int[26], arr2 = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            arr2[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(arr[i] - arr2[i]);
        }
        return count;
    }
}
