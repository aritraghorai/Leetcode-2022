package BinaryTree;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:28/02/2023
 ?Program Details:652. Find Duplicate Subtrees
*https://leetcode.com/problems/find-duplicate-subtrees/
   */
public class Q16_Find_Duplicate_Subtree {
    HashMap<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        solve(root, res);
        return res;
    }

    public String solve(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return "#";
        }
        String s = solve(root.left, res) + "," + solve(root.right, res) + "," + root.val;
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) {
            res.add(root);
        }
        return s;
    }

}
