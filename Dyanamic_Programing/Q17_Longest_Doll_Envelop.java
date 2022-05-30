package Dyanamic_Programing;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:25/05/2022
 ?Program Details:354. Russian Doll Envelopes
 *https://leetcode.com/problems/russian-doll-envelopes/
   */
public class Q17_Longest_Doll_Envelop {
    public int maxEnvelopesTle(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int res = 1;

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        // *Filling The dp array
        dp[0] = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }
        return res;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int maxLen = 0;

        int[] dp = new int[envelopes.length];

        for (int i = 0; i < envelopes.length; i++) {
            int width = envelopes[i][0];
            int left = Arrays.binarySearch(dp, 0, maxLen, width);
            if (left < 0) {
                left = -(left + 1);
            }
            dp[left] = envelopes[i][0];
            if (left == maxLen) {
                maxLen++;
            }
        }
        return maxLen;
    }

}
