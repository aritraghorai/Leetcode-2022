package Array;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:20/02/2022
 ?Program Details:1288. Remove Covered Intervals
 *https://leetcode.com/problems/remove-covered-intervals/
   */
public class Q5_Remove_Covered_Interval {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        int end = 0;
        int count = 0;
        for (int[] inter : intervals) {
            if (inter[1] > end) {
                count++;
                end = inter[1];
            }
        }
        return count;
    }
}
