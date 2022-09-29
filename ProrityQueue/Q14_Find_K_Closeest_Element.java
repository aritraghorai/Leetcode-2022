package ProrityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:29/09/2022
 ?Program Details:658. Find K Closest Elements
*https://leetcode.com/problems/find-k-closest-elements/
   */
public class Q14_Find_K_Closeest_Element {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        for (int i : arr) {
            pq.offer(new int[] { Math.abs(x - i), i });
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll()[1]);
        }
        Collections.sort(res);
        return res;

    }
}
