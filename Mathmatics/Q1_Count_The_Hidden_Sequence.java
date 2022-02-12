package Mathmatics;

/*
 !Name: Aritra Ghorai
 !Date:04/02/2022
 ?Program Details:2145. Count the Hidden Sequences
 *https://leetcode.com/problems/count-the-hidden-sequences/ 
   */
public class Q1_Count_The_Hidden_Sequence {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long mini = lower, maxi = lower;
        long ele = lower;
        for (int i : differences) {
            ele += i;
            mini = Math.min(mini, ele);
            maxi = Math.max(maxi, ele);
        }
        int ans = (int) ((upper - lower) - (maxi - mini) + 1);
        return ans > 0 ? ans : 0;
    }
}
