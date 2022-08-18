package ProrityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 !Name: Aritra Ghorai
 !Date:18/08/2022
 ?Program Details:1338. Reduce Array Size to The Half
 *https://leetcode.com/problems/reduce-array-size-to-the-half/
   */
public class Q12_Reduce_Size_To_Half {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach((ele) -> {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });
        map.forEach((k, v) -> {
            pq.offer(new int[] { k, v });
        });
        int si = arr.length;
        int temp = si;
        int count = 0;
        while (temp > si / 2) {
            temp -= pq.poll()[1];
            count++;
        }
        return count;
    }
}
