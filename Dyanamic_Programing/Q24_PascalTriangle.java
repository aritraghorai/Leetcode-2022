package Dyanamic_Programing;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:19/07/2022
 ?Program Details:118. Pascal's Triangle
 *https://leetcode.com/problems/pascals-triangle/
   */
public class Q24_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    temp.add(res.get(i - 2).get(0));
                } else if (j == i - 1) {
                    temp.add(res.get(i - 2).get(res.get(i - 2).size() - 1));
                } else {
                    temp.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }
}
