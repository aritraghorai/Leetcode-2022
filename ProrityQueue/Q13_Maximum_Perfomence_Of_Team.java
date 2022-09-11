package ProrityQueue;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:11/09/2022
 ?Program Details: 1383. Maximum Performance of a Team
 *https://leetcode.com/problems/maximum-performance-of-a-team/
   */
public class Q13_Maximum_Perfomence_Of_Team {
    class team_pair {
        int speed;
        int efficiency;

        public team_pair(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }

    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = 1000000007;
        List<team_pair> teams = new ArrayList<>();
        for (int i = 0; i < speed.length; i++) {
            teams.add(new team_pair(speed[i], efficiency[i]));
        }
        Collections.sort(teams, (a, b) -> {
            return b.efficiency - a.efficiency;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        long teamPerformance = 0, teamSpeed = 0;
        for (team_pair p : teams) {
            if (pq.size() > k) {
                teamSpeed -= pq.poll();
            }
            pq.offer(p.speed);
            teamSpeed += p.speed;
            teamPerformance = Math.max(teamPerformance, teamSpeed * p.efficiency);
        }
        return (int) (teamPerformance % mod);
    }
}
