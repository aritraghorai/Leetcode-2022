package HashMap;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:20/07/2022
 ?Program Details:792. Number of Matching Subsequences
 *https://leetcode.com/problems/number-of-matching-subsequences/
   */
public class Q15_Number_Of_Matching_Subsequence {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), new ArrayList<>());
            }
            map.get(s.charAt(i)).add(i);
        }
        for (String word : words) {
            int low = -1;
            boolean isSubsequence = true;
            for (char c : word.toCharArray()) {
                if (!map.containsKey(c)) {
                    isSubsequence = false;
                    break;
                }
                var tempList = map.get(c);
                int newLow = low;
                for (int i : tempList) {
                    if (i > newLow) {
                        newLow = i;
                        break;
                    }
                }
                if (newLow == low) {
                    isSubsequence = false;
                    break;
                }
                low = newLow;
            }
            if (isSubsequence) {
                count++;
            }
        }
        return count;

    }
}
