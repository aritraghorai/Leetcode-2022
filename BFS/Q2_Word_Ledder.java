package BFS;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:12/02/2022
 ?Program Details:127. Word Ladder
 *https://leetcode.com/problems/word-ladder/
   */
public class Q2_Word_Ledder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var set1 = new HashSet<String>();
        var set2 = new HashSet<String>();
        var qu = new LinkedList<String>();
        for (var s : wordList) {
            set1.add(s);
        }
        if (!set1.contains(endWord))
            return 0;
        qu.add(beginWord);
        int step = 0;
        while (!qu.isEmpty()) {
            int si = qu.size();
            while (si-- > 0) {
                var rsA = qu.poll().toCharArray();
                set2.add(new String(rsA));
                for (int i = 0; i < rsA.length; i++) {
                    char oldChar = rsA[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        rsA[i] = c;
                        String s = new String(rsA);
                        if (set1.contains(s) && !set2.contains(s)) {
                            if (s.equals(endWord))
                                return step;
                            qu.offer(s);
                        }
                    }
                    rsA[i] = oldChar;
                }
            }
            step++;
        }
        return 0;
    }

}
