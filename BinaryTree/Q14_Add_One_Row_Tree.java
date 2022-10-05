package BinaryTree;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:05/10/2022
 ?Program Details:623. Add One Row to Tree
*https://leetcode.com/problems/add-one-row-to-tree/description/
   */
public class Q14_Add_One_Row_Tree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        LinkedList<TreeNode> qu = new LinkedList<>();
        int curDepth = 1;
        qu.offer(root);
        while (!qu.isEmpty()) {
            int si = qu.size();
            if (curDepth == depth - 1) {
                break;
            }
            for (int i = 1; i <= si; i++) {
                TreeNode rn = qu.poll();
                if (rn.left != null) {
                    qu.offer(rn.left);
                }
                if (rn.right != null) {
                    qu.offer(rn.right);
                }
            }
            curDepth += 1;
        }
        while (!qu.isEmpty()) {
            TreeNode rn = qu.poll();
            if (rn.left != null) {
                TreeNode nn = new TreeNode(val);
                nn.left = rn.left;
                rn.left = nn;
            }
            if (rn.right != null) {
                TreeNode nn = new TreeNode(val);
                nn.right = rn.right;
                rn.right = nn;
            }
        }
        return root;
    }
}
