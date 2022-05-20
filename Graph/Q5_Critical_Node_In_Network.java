package Graph;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:18/05/2022
 ?Program Details:1192. Critical Connections in a Network
 *https://leetcode.com/problems/critical-connections-in-a-network/
   */
public class Q5_Critical_Node_In_Network {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(2));
        }
        System.err.println(graph);
        return getBridges(graph, n);
    }

    public List<List<Integer>> getBridges(List<List<Integer>> graph, int n) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] isVisited = new boolean[n];
        int[] timerArray = new int[n];
        int[] low = new int[n];
        int timer = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i, -1, isVisited, timerArray, low, graph, timer, res);
            }
        }
        return res;
    }

    private void dfs(int node, int parent, boolean[] isVisited, int[] timerArray, int[] low, List<List<Integer>> graph,
            int timer, List<List<Integer>> res) {
        isVisited[node] = true;
        timerArray[node] = low[node] = timer++;
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            if (!isVisited[child]) {
                dfs(child, node, isVisited, timerArray, low, graph, timer, res);
                low[node] = Math.min(low[node], low[child]);
                if (low[child] > timerArray[node]) {
                    res.add(List.of(node, child));
                }
            } else {
                low[node] = Math.min(low[node], timerArray[child]);
            }
        }
    }

}
