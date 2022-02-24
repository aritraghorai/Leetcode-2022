package ProrityQueue;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:19/02/2022
 ?Program Details:1675. Minimize Deviation in Array
 *https://leetcode.com/problems/minimize-deviation-in-array/
   */
public class Q1_Minimum_derivation_array {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(minimumDeviation(nums));
    }

    public static int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int min = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int a : nums) {
            if (a % 2 == 1)
                a *= 2;
            pq.add(a);
            min = Math.min(min, a);
        }
        while (true) {
            int a = pq.poll();
            res = Math.min(a - min, res);
            if (a % 2 == 1)
                break;
            min = Math.min(min, a / 2);
            pq.add(a / 2);
        }
        return res;
    }
}
