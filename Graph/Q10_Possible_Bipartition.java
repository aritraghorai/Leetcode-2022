package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 !Name: Aritra Ghorai
 !Date:21/12/2022
 ?Program Details: 886. Possible Bipartition
*https://leetcode.com/problems/possible-bipartition/
   */
public class Q10_Possible_Bipartition {
  public static void main(String[] args) {
    int[][] arr = { { 1, 3 }, { 1, 2 }, { 2, 4 } };
    System.out.println(possibleBipartition(4, arr));
  }

  public static boolean possibleBipartition(int n, int[][] dislikes) {
    List<List<Integer>> graph = new ArrayList<>();
    int[] color = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int[] dislike : dislikes) {
      graph.get(dislike[0]).add(dislike[1]);
      graph.get(dislike[1]).add(dislike[0]);
    }
    for (int i = 1; i <= n; i++) {
      if (color[i] != 0) {
        continue;
      }
      LinkedList<Integer> qu = new LinkedList<>();
      color[i] = 1;
      qu.offer(i);
      while (!qu.isEmpty()) {
        int rn = qu.poll();
        for (int k : graph.get(rn)) {
          if (color[rn] == color[k]) {
            return false;
          }
          if (color[k] == 0) {
            qu.offer(k);
            color[k] = -color[rn];
          }
        }
      }

    }
    return true;
  }
}
