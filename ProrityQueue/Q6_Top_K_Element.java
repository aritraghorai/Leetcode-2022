package ProrityQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:09/04/2022
 ?Program Details:347. Top K Frequent Elements
 *https://leetcode.com/problems/top-k-frequent-elements/ 
   */
public class Q6_Top_K_Element {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return map.get(o2) - map.get(o1);
      }
    });
    for (int i : map.keySet()) {
      pq.add(i);
    }
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = pq.poll();
    }
    return res;
  }
}
