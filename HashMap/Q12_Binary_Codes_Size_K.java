package HashMap;

import java.util.HashSet;

/*
 !Name: Aritra Ghorai
 !Date:31/05/2022
 ?Program Details:1461. Check If a String Contains All Binary Codes of Size K
 *https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
   */
public class Q12_Binary_Codes_Size_K {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        System.out.println(set);
        return set.size() == Math.pow(2, k);
    }
}
