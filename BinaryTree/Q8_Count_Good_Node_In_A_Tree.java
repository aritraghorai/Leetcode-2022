package BinaryTree;

/*
 !Name: Aritra Ghorai
 !Date:01/09/2022
 ?Program Details:1448. Count Good Nodes in Binary Tree
 *https://leetcode.com/problems/count-good-nodes-in-binary-tree/ 
   */
public class Q8_Count_Good_Node_In_A_Tree {
    private int count = 0;

    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return count;
    }

    private void helper(TreeNode root, int preMaximum) {
        if (root == null) {
            return;
        }
        if (preMaximum <= root.val) {
            count++;
        }
        preMaximum = Math.max(preMaximum, root.val);
        helper(root.left, preMaximum);
        helper(root.right, preMaximum);

    }
}
