package Graph;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:30/04/2022
 ?Program Details:399. Evaluate Division
 *https://leetcode.com/problems/evaluate-division/
   */
public class Q3_Evalouate_Division {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // *Frist Create The Graph
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        int i = 0;
        for (var equation : equations) {
            String st = equation.get(0);
            String end = equation.get(1);
            graph.putIfAbsent(st, new HashMap<>());
            graph.get(st).put(end, values[i]);
            graph.putIfAbsent(end, new HashMap<>());
            graph.get(end).put(st, 1 / values[i]);
            i++;
        }
        // *Use Dfs For Create Result Array
        double[] res = new double[queries.size()];
        i = 0;
        for (var querie : queries) {
            String start = querie.get(0);
            String end = querie.get(1);
            if (start.equals(end)) {
                if (graph.containsKey(start)) {
                    res[i++] = 1.0;
                } else {
                    res[i++] = -1.0;
                }
            } else {
                double resD = dfs(start, end, graph, new HashSet<String>());
                res[i] = resD;
                i++;
            }
        }
        return res;
    }

    private double dfs(String start, String end, HashMap<String, HashMap<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        visited.add(start);
        for (String neighbiur : graph.get(start).keySet()) {
            if (!visited.contains(neighbiur)) {
                double neighbourRes = dfs(neighbiur, end, graph, visited);
                if (neighbourRes != -1.0) {
                    return neighbourRes * graph.get(start).get(neighbiur);
                }
            }
        }
        return -1.0;
    }

}
