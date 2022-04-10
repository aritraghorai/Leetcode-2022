package ProrityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:07/04/2022
 ?Program Details:1046. Last Stone Weight
 *https://leetcode.com/problems/last-stone-weight/ 
   */
public class Q4_Last_Stone_Weight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones) {
            pq.add(i);
        }
        while (pq.size() != 1) {
            if (pq.size() == 2) {
                int a = pq.poll();
                int b = pq.poll();
                pq.add(a - b);
            }
        }
        return pq.poll();
    }

}
