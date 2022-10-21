package Binary_Search;

/*
 !Name: Aritra Ghorai
 !Date:27/02/2022
 ?Program Details:2187. Minimum Time to Complete Trips
 *https://leetcode.com/problems/minimum-time-to-complete-trips/
   */
public class Q1_Minimum_Time_Complete_Tip {
  public static void main(String[] args) {
    int[] arr = { 10000 };
    System.out.println(minimumTime(arr, 10000000));
  }

  public static long minimumTime(int[] time, int totalTrips) {
    // if (time.length == 1) {
    // return time[0] * totalTrips;
    // }
    long low = 0;
    long min = Integer.MIN_VALUE;
    for (int i : time) {
      min = Math.max(min, i);
    }
    long high = min * totalTrips;
    long ans = 0;
    while (low <= high) {
      long mid = low + ((high - low) >> 1);
      if (timeOK(time, mid, totalTrips)) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }

  private static boolean timeOK(int[] time, long mid, int totalTrips) {
    long tips = 0;
    for (int t : time) {
      tips += (mid / t);
      if (tips > totalTrips)
        return true;
    }
    return tips >= totalTrips ? true : false;

  }
}
