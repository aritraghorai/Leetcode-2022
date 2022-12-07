package Binary_Search_Tree;

/*
 !Name: Aritra Ghorai
 !Date:07/12/2022
 ?Program Details:938. Range Sum of BST
 *https://leetcode.com/problems/range-sum-of-bst/
   */
public class Q6_Range_Sum_Bst {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum;
    }

    public void helper(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val < low) {
            helper(root.right, low, high);
        } else if (root.val > high) {
            helper(root.left, low, high);
        } else {
            helper(root.left, low, high);
            helper(root.right, low, high);
            sum += root.val;
        }
    }

}
