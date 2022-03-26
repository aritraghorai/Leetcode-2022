package Greedy;

import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:25/03/2022
 ?Program Details:1029. Two City Scheduling
 *https://leetcode.com/problems/two-city-scheduling/ 
   */
public class Q7_Two_City_Scheduling {
    public int twoCitySchedCost(int[][] costs) {
        // *All People cost to sent city a
        int totalACost = 0;
        for (int[] cost : costs) {
            totalACost += cost[0];
        }
        Arrays.sort(costs, (a, b) -> {
            return (-a[0] + a[1]) - (-b[0] + b[1]);
        });
        for (int i = 0; i < costs.length / 2; i++) {
            totalACost += -costs[i][0] + costs[i][1];
        }
        return totalACost;
    }
}
