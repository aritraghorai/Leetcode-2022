package Bfs;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:11/01/2023
 ?Program Details:1443. Minimum Time to Collect All Apples in a Tree 
 *https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
   */
public class Q6_Minimum_Time_Cost_To_Collect_Apple {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return helper(0, -1, tree, hasApple);

    }

    public int helper(int root, int partent, ArrayList<ArrayList<Integer>> tree, List<Boolean> hasApple) {

        int res = 0;
        for (int child : tree.get(root)) {
            if (partent == child) {
                continue;
            }
            int childTime = helper(child, root, tree, hasApple);
            if (hasApple.get(child) || childTime != 0) {
                res += 2;
            }
        }

        return res;

    }

}
