package Graph;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:07/03/2022
 ?Program Details:2192. All Ancestors of a Node in a Directed Acyclic Graph
 *https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/ 
   */
public class Q2_All_Ancestor_Of_Asyclic_Graph {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<Integer>());
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < n; i++) {

            boolean[] visit = new boolean[n];
            dfs(i, visit, graph);
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (visit[j]) {
                    res.get(j).add(i);
                }
            }
        }
        return res;

    }

    private void dfs(int sv, boolean[] visit, List<List<Integer>> graph) {
        visit[sv] = true;
        for (int j : graph.get(sv)) {
            if (visit[j])
                continue;
            dfs(j, visit, graph);
        }
    }

}
