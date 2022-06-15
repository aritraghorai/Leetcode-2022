package Dyanamic_Programing;

import java.util.HashMap;

/*
 !Name: Aritra Ghorai
 !Date:15/06/2022
 ?Program Details:1048. Longest String Chain
 *https://leetcode.com/problems/longest-string-chain/
   */
public class Q19_Longest_String_Chain {
    public static void main(String[] args) {
        String[] words = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
        System.out.println(longestStrChain(words));
    }

    public static int longestStrChain(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        int res = 1;
        Integer[] dp = new Integer[words.length];
        for (int i = 0; i < words.length; i++) {
            res = Math.max(res, helper(words, map, i, dp));
        }

        return res;
    }

    public static int helper(String[] words, HashMap<String, Integer> map, int index, Integer[] dp) {
        if (words[index].length() == 1) {
            return 1;
        }
        if (dp[index] != null)
            return dp[index];
        int res = 1;
        for (int i = 0; i < words[index].length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(words[index].substring(0, i));
            sb.append(words[index].substring(i + 1, words[index].length()));
            if (map.containsKey(sb.toString())) {
                System.out.println(sb.toString());
                res = Math.max(res, helper(words, map, map.get(sb.toString()), dp) + 1);
            }
        }
        return dp[index] = res;
    }
}
