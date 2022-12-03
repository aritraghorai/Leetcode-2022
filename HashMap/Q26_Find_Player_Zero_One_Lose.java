package HashMap;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:28/11/2022
 ?Program Details:2225. Find Players With Zero or One Losses
*https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/
   */
public class Q26_Find_Player_Zero_One_Lose {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Boolean> winner = new HashMap<>();
        HashMap<Integer, Integer> looser = new HashMap<>();

        for (int[] match : matches) {
            if (!winner.containsKey(match[0])) {
                winner.put(match[0], true);
            }
            looser.put(match[1], looser.getOrDefault(match[1], 0) + 1);
            if (looser.containsKey(match[0])) {
                winner.put(match[0], false);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        for (int i : winner.keySet()) {
            if (!looser.containsKey(i)) {
                res1.add(i);
            }
        }
        for (int i : looser.keySet()) {
            if (looser.get(i) == 1) {
                res2.add(i);
            }
        }
        Collections.sort(res1);
        Collections.sort(res2);
        res.add(res1);
        res.add(res2);
        return res;

    }

    public List<List<Integer>> findWinners1(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ans.add(new ArrayList<>());
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] m : matches) {
            map.merge(m[1], 1, Integer::sum);
            map.merge(m[0], 0, Integer::sum);
        }
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val > 1) {
                continue;
            }
            ans.get(val).add(key);
        }
        for (int i = 0; i < 2; i++) {
            Collections.sort(ans.get(i));
        }
        return ans;
    }
}
