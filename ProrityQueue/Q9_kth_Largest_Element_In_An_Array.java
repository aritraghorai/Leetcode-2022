package ProrityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:22/06/2022
 ?Program Details: 
   */
public class Q9_kth_Largest_Element_In_An_Array {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : nums) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
