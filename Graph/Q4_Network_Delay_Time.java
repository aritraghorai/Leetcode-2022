package Graph;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:14/05/2022
 ?Program Details:743. Network Delay Time
 *https://leetcode.com/problems/network-delay-time/
   */
public class Q4_Network_Delay_Time {
    public int networkDelayTime(int[][] times, int n, int k) {
        // *Graph Representation
        ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            graph.add(new HashMap<>());
        }
        for (int[] time : times) {
            graph.get(time[0] - 1).put(time[1] - 1, time[2]);
        }
        PriorityQueue<DijkstraNode> pq = new PriorityQueue<>();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k - 1] = 0;
        pq.add(new DijkstraNode(k - 1, 0));
        while (!pq.isEmpty()) {
            var rp = pq.poll();
            for (int i : graph.get(rp.node).keySet()) {
                if (distances[i] >= rp.dis + graph.get(rp.node).get(i)) {
                    distances[i] = rp.dis + graph.get(rp.node).get(i);
                    pq.offer(new DijkstraNode(i, distances[i]));
                }
            }
        }
        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            if (distances[i] == Integer.MAX_VALUE)
                return -1;
            maxDistance = Math.max(maxDistance, distances[i]);
        }
        return maxDistance;

    }
}

class DijkstraNode implements Comparable<DijkstraNode> {
    int node;
    int dis;

    public DijkstraNode(int node, int dis) {
        this.node = node;
        this.dis = dis;
    }

    @Override
    public int compareTo(DijkstraNode o) {
        return this.dis - o.dis;
    }

}
