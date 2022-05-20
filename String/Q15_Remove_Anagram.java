package String;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:15/05/2022
 ?Program Details: 5234. Find Resultant Array After Removing Anagrams
 *https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
   */
public class Q15_Remove_Anagram {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new LinkedList<>();
        for (String word : words) {
            if (res.isEmpty() || !isAnagram(word, res.get(res.size() - 1)))
                res.add(word);
        }
        return res;
    }

    public Boolean isAnagram(String w1, String w2) {
        if (w1.length() != w2.length())
            return false;
        else {
            char[] word1 = w1.toCharArray();
            Arrays.sort(word1);
            char[] word2 = w2.toCharArray();
            Arrays.sort(word2);
            return Arrays.equals(word1, word2);
        }
    }
}
