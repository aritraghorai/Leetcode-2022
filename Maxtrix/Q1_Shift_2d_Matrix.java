package Maxtrix;

import java.util.ArrayList;
import java.util.List;

/*
 !Name: Aritra Ghorai
 !Date:11/04/2022
 ?Program Details:1260. Shift 2D Grid
 *https://leetcode.com/problems/shift-2d-grid/
   */
public class Q1_Shift_2d_Matrix {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int rowSize = grid.length;
        int colmSize = grid[0].length;
        for (int i = 0; i < rowSize; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < colmSize; j++) {
                temp.add(0);
            }
            res.add(temp);
        }
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colmSize; j++) {
                int newColm = (j + k) % colmSize;
                int newRow = (j + k) / colmSize;
                newRow = (i + newRow) % rowSize;
                res.get(newRow).set(newColm, grid[i][j]);
            }
        }
        return res;
    }
}
