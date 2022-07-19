package Dyanamic_Programing;

import java.util.Arrays;
import java.util.Collections;

/*
 !Name: Aritra Ghorai
 !Date:12/07/2022
 ?Program Details:473. Matchsticks to Square
 *https://leetcode.com/problems/matchsticks-to-square/
   */
public class Q22_Matchsticks_To_Square {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i : matchsticks) {
            sum += i;
        }
        int len = sum / 4;
        if (((double) sum / 4.0) != len) {
            return false;
        }
        int[] dp = new int[4];
        matchsticks = Arrays.stream(matchsticks).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        return helper(matchsticks, 0, dp, len);
    }

    public boolean helper(int[] matchsticks, int idx, int[] dp, int len) {
        if (idx == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (dp[i] + matchsticks[idx] <= len) {
                dp[i] += matchsticks[idx];
                if (helper(matchsticks, idx + 1, dp, len)) {
                    return true;
                }
                dp[i] -= matchsticks[idx];
            }
        }
        return false;
    }
}
