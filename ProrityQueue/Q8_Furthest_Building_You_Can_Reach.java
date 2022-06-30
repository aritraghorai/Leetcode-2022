package ProrityQueue;

import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:22/06/2022
 ?Program Details:1642. Furthest Building You Can Reach
 *https://leetcode.com/problems/furthest-building-you-can-reach/ 
   */
public class Q8_Furthest_Building_You_Can_Reach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int reachByBricks = 0;
        int i = 0;
        for (; i < heights.length - 1; i++) {
            if (heights[i] < heights[i + 1]) {
                pq.offer(heights[i + 1] - heights[i]);
            }
            while (pq.size() > ladders) {
                reachByBricks += pq.poll();
            }
            if (reachByBricks > bricks) {
                break;
            }
        }
        return i;
    }
}
