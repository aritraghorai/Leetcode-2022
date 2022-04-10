package ProrityQueue;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:08/04/2022
 ?Program Details:703. Kth Largest Element in a Stream
 *https://leetcode.com/problems/kth-largest-element-in-a-stream/
   */
public class Q5_Kth_Largest_Element_In_A_Stream {

}

class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int i : nums)
            add(i);
    }

    public int add(int val) {
        int n = pq.size();
        if (n < k) {
            pq.offer(val);
        } else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
