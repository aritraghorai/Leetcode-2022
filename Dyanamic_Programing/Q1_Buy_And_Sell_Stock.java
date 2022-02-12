package Dyanamic_Programing;

/*
 !Name: Aritra Ghorai
 !Date:01/02/2022
 ?Program Details:121. Best Time to Buy and Sell Stock
 *https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ 
   */
public class Q1_Buy_And_Sell_Stock {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            max = Math.max(Math.abs(min - prices[i]), max);
        }
        return Math.max(0, max);
    }
}
