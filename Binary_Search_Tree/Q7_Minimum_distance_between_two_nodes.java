package Binary_Search_Tree;

/*
 !Name: Aritra Ghorai
 !Date:17/02/2023
 ?Program Details:783. Minimum Distance Between BST Nodes
 *https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
   */
public class Q7_Minimum_distance_between_two_nodes {
    TreeNode pre = null;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorderTraversal(root);
        return min;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        inorderTraversal(root.right);
    }

}
