package Binary_Search_Tree;

/*
 !Name: Aritra Ghorai
 !Date:18/04/2022
 ?Program Details:230. Kth Smallest Element in a BST
 *https://leetcode.com/problems/kth-smallest-element-in-a-bst/
   */
public class Q4_Kth_Smallest_Element {
    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root, pre = null;
        int n = 0, res = 0;
        while (curr != null) {
            if (curr.left == null) {
                n++;
                if (n == k) {
                    res = curr.val;
                }
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    n++;
                    if (n == k) {
                        res = curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return res;
    }

}
