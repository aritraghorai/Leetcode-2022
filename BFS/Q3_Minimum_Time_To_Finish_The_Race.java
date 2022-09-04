package Bfs;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:27/02/2022
 ?Program Details:2188. Minimum Time to Finish the Race
 *https://leetcode.com/problems/minimum-time-to-finish-the-race/ 
   */
public class Q3_Minimum_Time_To_Finish_The_Race {
    public static void main(String[] args) {
        int[][] tires = { { 2, 3 }, { 3, 4 } };
        System.out.println(minimumFinishTime(tires, 5, 4));

    }

    public static int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        long[] best = new long[numLaps + 1];
        int maxLap = 0;
        Arrays.fill(best, Long.MAX_VALUE);
        for (int[] tire : tires) {
            int fi = tire[0];
            long ri = tire[1];
            long time = fi;
            long curLapTime = fi;
            for (int i = 1; i <= numLaps && fi + changeTime > curLapTime; i++) {
                if (time < best[i]) {
                    best[i] = time;
                }
                maxLap = Math.max(maxLap, i);
                curLapTime *= ri;
                time += curLapTime;
            }
        }
        return f(best, maxLap, changeTime, numLaps, new Integer[numLaps + 1]);
    }

    static int f(long[] best, int maxLap, int changeTime, int lap, Integer[] dp) {
        if (lap == 0)
            return -changeTime;
        if (dp[lap] != null)
            return dp[lap];
        long mini = (int) 1e9;
        for (int i = 1; i <= Math.min(maxLap, lap); i++) {
            mini = Math.min(mini, f(best, maxLap, changeTime, lap - i, dp) + changeTime + best[i]);
        }
        return dp[lap] = (int) mini;
    }

}
