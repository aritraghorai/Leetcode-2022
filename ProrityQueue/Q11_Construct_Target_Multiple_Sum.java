package ProrityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:24/06/2022
 ?Program Details:1354. Construct Target Array With Multiple Sums
 *https://leetcode.com/problems/construct-target-array-with-multiple-sums/
   */
public class Q11_Construct_Target_Multiple_Sum {
    public static void main(String[] args) {
        int[] target = { 9, 3, 5 };
        System.out.println(isPossible(target));
    }

    public static boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int i : target) {
            sum += i;
            pq.offer(i);
        }
        while (pq.peek() != 1) {
            int top = pq.poll();
            long diff = sum - top;
            if (diff == 1)
                return true;
            if (diff > top || diff == 0 || top % diff == 0) {
                return false;
            }
            top %= diff;
             sum = top + diff;
            pq.offer(top);
        }
        return true;
    }
}
