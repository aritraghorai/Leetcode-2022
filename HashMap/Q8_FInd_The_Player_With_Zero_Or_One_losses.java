package HashMap;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:03/04/2022
 ?Program Details:5235. Find Players With Zero or One Losses
 *https://leetcode.com/contest/weekly-contest-287/problems/find-players-with-zero-or-one-losses/
 *https://leetcode.com/problems/find-players-with-zero-or-one-losses/
   */
public class Q8_FInd_The_Player_With_Zero_Or_One_losses {
    public List<List<Integer>> findWinners(int[][] matches) {
        var onlyWinner = new TreeSet<Integer>();
        var onlyLooser = new TreeMap<Integer, Integer>();

        for (int[] match : matches) {
            if (!onlyLooser.containsKey(match[0])) {
                onlyWinner.add(match[0]);
            }
            if (onlyWinner.contains(match[1])) {
                onlyWinner.remove(match[1]);
            }
            onlyLooser.put(match[1], onlyLooser.getOrDefault(match[1], 0) + 1);
        }
        var list = new ArrayList<List<Integer>>();
        var onlyWinnerList = new ArrayList<Integer>();
        onlyWinnerList.addAll(onlyWinner);
        list.add(onlyWinnerList);
        var oneLooserlist = new ArrayList<Integer>();
        for (int i : onlyLooser.keySet()) {
            if (onlyLooser.get(i) == 1) {
                oneLooserlist.add(i);
            }
        }
        list.add(oneLooserlist);
        return list;

    }
}
