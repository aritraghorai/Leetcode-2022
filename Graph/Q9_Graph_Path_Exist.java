package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 !Name: Aritra Ghorai
 !Date:19/12/2022
 ?Program Details: 1971. Find if Path Exists in Graph
*https://leetcode.com/problems/find-if-path-exists-in-graph/
   */
public class Q9_Graph_Path_Exist {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        LinkedList<Integer> qu = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        var graph = buildGraph(edges, n);
        qu.offer(source);
        while (!qu.isEmpty()) {
            int si = qu.size();
            for (int i = 0; i < si; i++) {
                int rn = qu.poll();
                if (rn == destination) {
                    return true;
                }
                set.add(rn);
                for (int j : graph.get(rn)) {
                    if (!set.contains(j)) {
                        qu.add(j);
                    }
                }
            }

        }
        return false;
    }

    private List<List<Integer>> buildGraph(int[][] edges, int si) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < si; i++) {
            res.add(new ArrayList<>());
        }
        for (int[] i : edges) {
            res.get(i[0]).add(i[1]);
            res.get(i[1]).add(i[0]);
        }
        return res;
    }
}
