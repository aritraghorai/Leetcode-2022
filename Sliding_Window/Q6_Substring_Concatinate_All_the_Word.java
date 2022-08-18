package Sliding_Window;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:13/08/2022
 ?Program Details: 
   */
public class Q6_Substring_Concatinate_All_the_Word {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = { "bar", "foo", "the" };
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordsMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        Arrays.stream(words).forEach(word -> {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        });
        int wordSize = words[0].length();
        int windowSi = wordSize * words.length;
        if (windowSi > s.length()) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < windowSi; i++) {
            sb.append(s.charAt(i));
        }

        if (isValidWindow(sb.toString(), wordSize, wordsMap)) {
            res.add(0);
        }
        int i = 0;
        int j = windowSi;
        while (j < s.length()) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(j));
            if (isValidWindow(sb.toString(), wordSize, wordsMap)) {
                res.add(i + 1);
            }
            i++;
            j++;
        }
        return res;

    }

    private static boolean isValidWindow(String s, int wordSize, HashMap<String, Integer> wordsMap) {
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        int p = wordSize;
        while (p <= s.length()) {
            String temp = s.substring(i, p);
            if (!wordsMap.containsKey(temp)) {
                return false;
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            i += wordSize;
            p += wordSize;
        }
        return map.equals(wordsMap);
    }
}
