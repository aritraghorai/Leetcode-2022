package ProrityQueue;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:30/09/2022
 ?Program Details:218. The Skyline Problem
 *https://leetcode.com/problems/the-skyline-problem/description/
   */
public class Q15_The_SkyLineProblem {
    public static void main(String[] args) {
        int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
        System.out.println(getSkyline(buildings));
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<skyLinePair> li = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] a : buildings) {
            li.add(new skyLinePair(a[0], -a[2]));
            li.add(new skyLinePair(a[1], a[2]));
        }
        Collections.sort(li);
        int cu = 0;
        // System.out.println(li);
        pq.offer(0);
        for (skyLinePair sp : li) {
            int val = sp.val;
            int height = sp.height;
            if (height < 0) {
                pq.offer(-height);
            } else {
                pq.remove(height);
            }
            if (cu != pq.peek()) {
                res.add(List.of(val, pq.peek()));
                cu = pq.peek();
            }
        }
        return res;
    }

}

class skyLinePair implements Comparable<skyLinePair> {
    int val;
    int height;

    skyLinePair(int v, int h) {
        val = v;
        height = h;
    }

    @Override
    public int compareTo(skyLinePair o) {
        return this.val == o.val ? this.height - o.height : this.val - o.val;
    }

    @Override
    public String toString() {
        return "skyLinePair [val=" + val + ", height=" + height + "]";
    };
}
