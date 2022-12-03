package Dyanamic_Programing;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:26/11/2022
 ?Program Details:1235. Maximum Profit in Job Scheduling
*https://leetcode.com/problems/maximum-profit-in-job-scheduling/
   */
public class Q30_Maximum_Profit_Job_Schedule {
    private class Time implements Comparable<Time> {
        int startTime;
        int endTime;
        int profit;

        public Time(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        @Override
        public int compareTo(Time o) {
            // return this.startTime - o.startTime;
            return this.endTime - o.endTime;
        }

    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Time[] jobs = new Time[n];
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            maxTime = Math.max(maxTime, endTime[i]);
            jobs[i] = new Time(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs);
        // return helper(jobs, 0, 0, n, new Integer[n][maxTime + 1]);
        return MaxProof(jobs, n);
    }

    int helper(Time[] jobs, int end, int index, int length, Integer[][] dp) {
        if (index == jobs.length) {
            return 0;
        }
        if (dp[index][end] == null) {
            dp[index][end] = -1;
            if (end <= jobs[index].startTime) {
                dp[index][end] = Math.max(helper(jobs, end, index + 1, length, dp),
                        jobs[index].profit + helper(jobs, jobs[index].endTime, index + 1, length, dp));
            } else {
                dp[index][end] = helper(jobs, end, index + 1, length, dp);
            }
        }
        return dp[index][end];
    }

    public int MaxProof(Time[] jobs, int n) {
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        int max = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], jobs[i].profit);
            for (int j = i - 1; j >= 0; j++) {
                if (jobs[i].startTime >= jobs[j].endTime) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i].profit);
                    break;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
