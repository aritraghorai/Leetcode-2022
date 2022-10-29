package Graph;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:29/10/2022
 ?Program Details:2136. Earliest Possible Day of Full Bloom
 *https://leetcode.com/problems/earliest-possible-day-of-full-bloom/description/
   */
public class Q7_Earliest_Possible_Day_Bloom {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Pair> li = new ArrayList<>();
        for (int i = 0; i < plantTime.length; i++) {
            li.add(new Pair(plantTime[i], growTime[i]));
        }
        Collections.sort(li, (a, b) -> {
            return b.growthTimeOfPlant - a.growthTimeOfPlant;
        });
        int i = 0;
        int max = 0;
        for (Pair p : li) {
            i += p.plantTimeOfPlant;
            max = Math.max(p.growthTimeOfPlant + i, max);
        }
        return max;
    }

    private class Pair {
        int plantTimeOfPlant;
        int growthTimeOfPlant;

        public Pair(int plantTimeOfPlant, int growthTimeOfPlant) {
            this.plantTimeOfPlant = plantTimeOfPlant;
            this.growthTimeOfPlant = growthTimeOfPlant;
        }
    }
}
