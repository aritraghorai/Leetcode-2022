package BinaryTree;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:15/05/2022
 ?Program Details:1302. Deepest Leaves Sum
 *https://leetcode.com/problems/deepest-leaves-sum/
   */
public class Q5_Depest_Leave_Sum {
  public int deepestLeavesSum(TreeNode root) {
    int res = 0;
    var qu = new LinkedList<TreeNode>();
    qu.offer(root);
    while (!qu.isEmpty()) {
      int si = qu.size();
      int sum = 0;

      for (int i = 0; i < si; i++) {
        var rn = qu.poll();
        sum += rn.val;
        if (rn.left != null) {
          qu.offer(rn.left);
        }
        if (rn.right != null) {
          qu.offer(rn.right);
        }
      }
      res = sum;
    }
    return res;
  }
}
