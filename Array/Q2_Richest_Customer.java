package Array;

/*
 !Name: Aritra Ghorai
 !Date:31/01/2022
 ?Program Details:1672. Richest Customer Wealth
 *https://leetcode.com/problems/richest-customer-wealth/
   */
public class Q2_Richest_Customer {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] a : accounts) {
            int sum = 0;
            for (int b : a) {
                sum += b;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
