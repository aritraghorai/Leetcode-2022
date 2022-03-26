package ProrityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:20/03/2022
 ?Program Details:2208. Minimum Operations to Halve Array Sum
 *https://leetcode.com/problems/minimum-operations-to-halve-array-sum/
   */
public class Q2_Halve_Array_Sum {
    public static void main(String[] args) {
        int[] nums = { 5, 19, 8, 1 };
        System.out.println(halveArray(nums));
    }

    public static int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for (int i : nums) {
            pq.offer((double) i);
            sum += i;
        }
        sum /= 2;
        int count = 0;
        while (sum > 0) {
            double ele = pq.poll();
            ele /= 2;
            sum -= ele;
            pq.offer(ele);
            count++;
        }
        return count;

    }
}
