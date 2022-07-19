package BinaryTree;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:11/07/2022
 ?Program Details:199. Binary Tree Right Side View
*https://leetcode.com/problems/binary-tree-right-side-view/
   */
public class Q7_Right_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int si = qu.size();
            for (int i = 1; i <= si; i++) {
                var rn = qu.poll();
                if (i == si) {
                    res.add(rn.val);
                }
                if (rn.left != null)
                    qu.offer(rn.left);
                if (rn.right != null) {
                    qu.offer(rn.right);
                }
            }
        }
        return res;
    }
}
