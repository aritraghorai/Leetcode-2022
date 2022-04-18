package Binary_Search_Tree;

/*
 !Name: Aritra Ghorai
 !Date:16/04/2022
 ?Program Details:538. Convert BST to Greater Tree
 *https://leetcode.com/problems/convert-bst-to-greater-tree/
   */
public class Q2_Covert_Bst_To_grater_Tree {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode rNode) {
        if (rNode == null)
            return;
        helper(rNode.right);
        sum += rNode.val;
        rNode.val = sum;
        helper(rNode.left);
    }

}
