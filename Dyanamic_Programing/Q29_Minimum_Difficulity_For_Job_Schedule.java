package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:16/10/2022
?Program Details:1335. Minimum Difficulty of a Job Schedule
*https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/ 
  */
public class Q29_Minimum_Difficulity_For_Job_Schedule {

  public int minDifficulty(int[] jobDifficulty, int d) {
    Integer[][] dp = new Integer[jobDifficulty.length + 1][d + 1];
    int res = f(jobDifficulty, 0, d, dp);
    if (res >= (int) (1e8)) {
      return -1;
    }
    return res;
  }

  public int f(int[] difficulty, int idx, int day, Integer[][] dp) {
    if (idx == difficulty.length && day == 0) {
      return 0;
    }
    if (idx == difficulty.length || day == 0) {
      return (int) (1e8);
    }
    if (dp[idx][day] != null) {
      return dp[idx][day];
    }
    int max = difficulty[idx];
    int res = Integer.MAX_VALUE;
    for (int i = idx; i < difficulty.length; i++) {
      max = Math.max(difficulty[i], max);
      // *Complete the day job
      res = Math.min(res, f(difficulty, i + 1, day - 1, dp) + max);
    }
    return dp[idx][day] = res;

  }

}
