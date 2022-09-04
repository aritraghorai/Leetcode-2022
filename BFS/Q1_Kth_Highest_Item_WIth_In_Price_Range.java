package Bfs;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:01/02/2022
 ?Program Details:2146. K Highest Ranked Items Within a Price Range
 *https://leetcode.com/problems/k-highest-ranked-items-within-a-price-range/ 
   */
public class Q1_Kth_Highest_Item_WIth_In_Price_Range {
  public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
    int n = grid.length;
    int m = grid[0].length;
    var distance = new int[n][m];
    for (int[] a : distance)
      Arrays.fill(a, Integer.MAX_VALUE);
    var qu = new LinkedList<List<Integer>>();
    int[] rowIn = { -1, 1, 0, 0 };
    int[] colIn = { 0, 0, +1, -1 };
    int low = pricing[0], high = pricing[1];
    int row = start[0], colm = start[1];
    qu.add(List.of(row, colm));
    distance[row][colm] = 0;
    List<List<Integer>> ds = new ArrayList<>();
    while (!qu.isEmpty()) {
      var ri = qu.poll();
      int x = ri.get(0), y = ri.get(1);
      if (grid[x][y] >= low && grid[x][y] <= high) {
        ds.add(ri);
      }
      for (int i = 0; i < 4; i++) {
        int newx = x + rowIn[i];
        int newy = y + colIn[i];
        if (newx < n && newy < m && newx >= 0 && newy >= 0 && grid[newx][newy] != 0
            && distance[newx][newy] != Integer.MAX_VALUE) {
          qu.offer(List.of(newx, newy));
          distance[newx][newy] = distance[x][y] + 1;
        }
      }
    }
    System.out.println(ds);
    Collections.sort(ds, (a, b) -> {
      int x1 = a.get(0), y1 = a.get(1), x2 = b.get(0), y2 = b.get(1);
      if (distance[x1][y1] != distance[x2][y2])
        return distance[x1][y1] - distance[x2][y2];
      if (grid[x1][y1] != grid[x2][y2])
        return grid[x1][y1] - grid[x2][y2];
      if (x1 != x2)
        return x1 - x2;
      return y1 - y2;
    });
    var result = new ArrayList<List<Integer>>();
    for (int i = 0; i < k && i < ds.size(); i++) {
      result.add(ds.get(i));
    }
    return result;
  }
}
