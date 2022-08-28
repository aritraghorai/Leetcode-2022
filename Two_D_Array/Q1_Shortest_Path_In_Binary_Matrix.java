package Two_D_Array;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:16/05/2022
 ?Program Details:1091. Shortest Path in Binary Matrix
 *https://leetcode.com/problems/shortest-path-in-binary-matrix/
   */
public class Q1_Shortest_Path_In_Binary_Matrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        var qu = new LinkedList<point>();
        qu.offer(new point(0, 0));
        int level = 0;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { -1, 0 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
        while (!qu.isEmpty()) {
            int si = qu.size();
            for (int i = 0; i < si; i++) {
                var rn = qu.poll();
                if (rn.x == grid.length - 1 && rn.y == grid[0].length - 1) {
                    return level + 1;
                }
                if (grid[rn.x][rn.y] >= 1) {
                    continue;
                }
                grid[rn.x][rn.y] = 2;
                for (int[] direction : directions) {
                    int x = rn.x + direction[0];
                    int y = rn.y + direction[1];
                    if (isValid(x, y, grid)) {
                        qu.offer(new point(x, y));
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private boolean isValid(int x, int y, int[][] grid) {
        return x >= 0 && y <= 0 && x < grid.length && y < grid[0].length;
    }

}

class point {
    int x;
    int y;

    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
