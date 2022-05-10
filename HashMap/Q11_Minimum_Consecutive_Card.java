package HashMap;

import java.util.HashMap;

/*
 !Name: Aritra Ghorai
 !Date:07/05/2022
 ?Program Details:2260. Minimum Consecutive Cards to Pick Up
 *https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
   */
public class Q11_Minimum_Consecutive_Card {
    public int minimumCardPickup(int[] cards) {
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                min = Math.min(min, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
