package Backtracking;

import java.util.*;;

/*
 !Name: Aritra Ghorai
 !Date:20/01/2023
 ?Program Details:491. Non-decreasing Subsequences
*https://leetcode.com/problems/non-decreasing-subsequences/
   */
public class Q9_Non_decresing_Subseuence {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums, new ArrayList<>(), 0);
        return res;
    }

    public void helper(int[] nums, List<Integer> temp, int index) {

        HashSet<Integer> set = new HashSet<>();
        if (temp.size() > 1) {
            res.add(new ArrayList<>(temp));
        }

        for (; index < nums.length; index++) {

            if (!set.contains(nums[index]) && (temp.size() == 0 || temp.get(temp.size() - 1) <= nums[index])) {
                set.add(nums[index]);
                temp.add(nums[index]);
                helper(nums, temp, index + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
