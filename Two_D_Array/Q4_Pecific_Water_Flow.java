package Two_D_Array;

import java.util.ArrayList;
import java.util.List;

/*
 !Name: Aritra Ghorai
 !Date:31/08/2022
 ?Program Details: 417. Pacific Atlantic Water Flow
 *https://leetcode.com/problems/pacific-atlantic-water-flow/
   */
public class Q4_Pecific_Water_Flow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            dfs(heights, 0, i, pacific, -1);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, i, 0, pacific, -1);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, n - 1, i, atlantic, -1);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, i, m - 1, atlantic, -1);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    public void dfs(int[][] grid, int row, int col, boolean[][] matrix, int pre) {
        if (row == -1 || col == -1 || row == grid.length || col == grid[0].length || matrix[row][col]) {
            return;
        }
        if (pre > grid[row][col]) {
            return;
        }
        matrix[row][col] = true;
        pre = grid[row][col];
        dfs(grid, row + 1, col, matrix, pre);
        dfs(grid, row, col + 1, matrix, pre);
        dfs(grid, row - 1, col, matrix, pre);
        dfs(grid, row, col - 1, matrix, pre);

    }
}
