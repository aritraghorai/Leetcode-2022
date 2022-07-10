package HashMap;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:05/07/2022
 ?Program Details:128. Longest Consecutive Sequence
 *https://leetcode.com/problems/longest-consecutive-sequence/ 
   */
public class Q13_longest_consecutive {
    public static void main(String[] args) {
        // int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        int[] nums = { 0, 1, 2, 4, 8, 5, 6, 7, 9, 3, 55, 88, 77, 99, 999999999 };
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        var set = new HashSet<>();
        int low = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            if (set.add(i))
                pq.offer(i);
        }

        int res = 1;
        int count = 0;
        System.out.println(set);
        low = pq.peek();
        for (int i = low;; i++) {
            if (set.contains(i)) {
                count++;
                pq.poll();
            } else {
                res = Math.max(count, res);
                count = 0;
                if (pq.size() == 0) {
                    break;
                }
                i = pq.peek() - 1;

            }
        }
        res = Math.max(count, res);
        return res;
    }

}
