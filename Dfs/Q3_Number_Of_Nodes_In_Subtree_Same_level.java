package Dfs;

import java.util.ArrayList;

/*
 !Name: Aritra Ghorai
 !Date:12/01/2023
 ?Program Details:1519. Number of Nodes in the Sub-Tree With the Same Label
*https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
   */
public class Q3_Number_Of_Nodes_In_Subtree_Same_level {

    int[] array;

    // public int[] countSubTrees(int n, int[][] edges, String labels) {

    // array = new int[n]; // output array

    // // creating adjacency list
    // ArrayList<Integer>[] a = new ArrayList[n];
    // for (int i = 0; i < n; i++) {
    // a[i] = new ArrayList<Integer>();
    // }

    // for (int[] x : edges) {
    // a[x[0]].add(x[1]);
    // a[x[1]].add(x[0]);
    // }

    // dfs(-1, 0, a, labels);
    // return array;
    // }

    int[] dfs(int prev, int curr, ArrayList<Integer>[] a, String labels) {
        int[] ans = new int[26]; // freq array
        for (int x : a[curr]) {
            if (prev != x) {
                // array return by the children node
                int[] res = dfs(curr, x, a, labels);
                // combining the frequencies of left and right subtrees into one array
                for (int i = 0; i < res.length; i++)
                    ans[i] += res[i];
            }
        }
        // incrementing the freq of curr node label and storing in output array
        array[curr] = ++ans[labels.charAt(curr) - 'a'];
        return ans;
    }

}
