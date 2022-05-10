package BinaryTree;

/*
 !Name: Aritra Ghorai
 !Date:08/05/2022
 ?Program Details:6057. Count Nodes Equal to Average of Subtree 
 *https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
   */
public class Q3_Node_Euqual_To_Average_Value {
    private int res = 0;

    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return res;
    }

    public int[] helper(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int tempRes = 0;
        tempRes = left[0] + right[0] + root.val;
        tempRes /= (left[1] + right[1] + 1);
        if (tempRes == root.val)
            res += 1;
        return new int[] { left[0] + right[0] + root.val, left[1] + right[1] + 1 };
    }
}
