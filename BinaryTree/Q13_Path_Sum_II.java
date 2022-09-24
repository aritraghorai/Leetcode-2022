package BinaryTree;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:24/09/2022
 ?Program Details:113. Path Sum II
*https://leetcode.com/problems/path-sum-ii/
   */
public class Q13_Path_Sum_II {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        f(root, new ArrayList<Integer>(), res, 0, targetSum);
        return res;
    }

    public void f(TreeNode ro, List<Integer> temp, List<List<Integer>> res, int sum, int targetSum) {
        if (ro == null) {
            return;
        }
        if (ro.left == null && ro.right == null) {
            if (sum == targetSum) {
                res.add(new ArrayList<>(temp));
            }
        }
        sum += ro.val;
        temp.add(ro.val);
        f(ro.left, temp, res, sum, targetSum);
        f(ro.right, temp, res, sum, targetSum);
        temp.remove(temp.size() - 1);
    }
}
