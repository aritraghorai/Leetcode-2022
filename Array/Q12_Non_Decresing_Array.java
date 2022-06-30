package Array;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:25/06/2022
 ?Program Details:665. Non-decreasing Array
 *https://leetcode.com/problems/non-decreasing-array/
   */
public class Q12_Non_Decresing_Array {
    public boolean checkPossibility(int[] nums) {
        int step = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (pq.peek() > nums[i]) {
                if (step == 0) {
                    return false;
                }
                step--;
                pq.poll();
                pq.offer(nums[i]);
            } else {
                pq.offer(nums[i]);
            }
        }
        return true;
    }
}
