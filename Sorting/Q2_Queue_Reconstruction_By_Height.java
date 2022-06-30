package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

/*
 !Name: Aritra Ghorai
 !Date:29/06/2022
 ?Program Details:406. Queue Reconstruction by Height
 *https://leetcode.com/problems/queue-reconstruction-by-height/
   */
public class Q2_Queue_Reconstruction_By_Height {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] pe : people) {
            res.add(pe[1], pe);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
