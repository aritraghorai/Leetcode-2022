package Backtracking;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:12/05/2022
 ?Program Details:47. Permutations II
 *https://leetcode.com/problems/permutations-ii/
   */
public class Q5_Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute(nums, 0);
    }

    public List<List<Integer>> permute(int[] nums, int s) {
        if (s == nums.length) {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;

        }
        int num = nums[s];
        List<List<Integer>> rec = permute(nums, s + 1);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> inner : rec) {
            for (int i = 0; i <= inner.size(); i++) {
                if (i < inner.size() && num == inner.get(i)) {
                    inner.add(i, num);
                    result.add(new ArrayList<>(inner));
                    inner.remove(i);
                    break;
                }
                inner.add(i, num);
                result.add(new ArrayList<>(inner));
                inner.remove(i);
            }
        }
        return result;
    }
}
