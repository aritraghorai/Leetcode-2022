package Backtracking;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:10/05/2022
 ?Program Details:216. Combination Sum III
 *https://leetcode.com/problems/combination-sum-iii/ 
   */
public class Q4_Combination_Sum_3 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, new ArrayList<>(), res, 1);
        return res;
    }

    public static void helper(int k, int n, List<Integer> temp, List<List<Integer>> res, int num) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (k <= 0 || n <= 0) {
            return;
        }

        for (int i = num; i <= 9; i++) {
            temp.add(i);
            helper(k - 1, n - i, temp, res, i + 1);
            temp.remove(temp.size() - 1);
        }

    }
}
