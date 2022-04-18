package Binary_Search_Tree;

/*
 !Name: Aritra Ghorai
 !Date:15/04/2022
 ?Program Details:669. Trim a Binary Search Tree
*https://leetcode.com/problems/trim-a-binary-search-tree/
   */
public class Q1_Trim_The_Binary_Search_Tree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
