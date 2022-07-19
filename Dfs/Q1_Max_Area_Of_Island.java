package Dfs;
/*
 !Name: Aritra Ghorai
 !Date:15/07/2022
 ?Program Details:695. Max Area of Island 
 *https://leetcode.com/problems/max-area-of-island/
   */

public class Q1_Max_Area_Of_Island {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    max = Math.max(max, helper(grid, i, j));
            }
        }
        return max;
    }

    private int helper(int[][] grid, int i, int j) {
        if (i == -1 || j == -1 || i == grid.length || j == grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        int res = 0;
        grid[i][j] = 0;
        res += helper(grid, i + 1, j);
        res += helper(grid, i, j + 1);
        res += helper(grid, i - 1, j);
        res += helper(grid, i, j - 1);
        return res + 1;
    }
}
