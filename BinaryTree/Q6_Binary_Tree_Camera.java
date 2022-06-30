package BinaryTree;

/*
 !Name: Aritra Ghorai
 !Date:17/06/2022
 ?Program Details:968. Binary Tree Cameras
 *https://leetcode.com/problems/binary-tree-cameras/ 
   */
public class Q6_Binary_Tree_Camera {
    int count = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null)
            return 0;
        if (helper(root) == -1) {
            count++;
        }
        return count;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 1;
        int lc = helper(root.left);
        int rc = helper(root.right);
        if (rc == -1 || lc == -1) {
            count++;
            return 0;
        }
        if (lc == 0 || rc == 0) {
            return 1;
        }
        return -1;
    }
}
