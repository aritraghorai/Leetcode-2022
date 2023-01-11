package Greedy;

import java.util.Arrays;

public class Q17_Maximum_Bag_with_full_capacity_rock {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] res = new int[rocks.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(res);
        int count = 0;
        for (int i : res) {
            if (additionalRocks < i) {
                break;
            }
            if (i == 0) {
                count++;
            } else {
                additionalRocks -= i;
                count++;
            }
        }
        return count;

    }
}
