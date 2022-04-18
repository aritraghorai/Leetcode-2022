package Binary_Search_Tree;

/*
 !Name: Aritra Ghorai
 !Date:17/04/2022
 ?Program Details:897. Increasing Order Search Tree
 *https://leetcode.com/problems/increasing-order-search-tree/ 
   */
public class Q3_Incresing_Order_In_BST {
    public TreeNode increasingBST(TreeNode root) {
        var dummy = new TreeNode();

        Helper(root, new TreeNode[] { dummy });
        return dummy.right;
    }

    public void Helper(TreeNode root, TreeNode[] temp) {
        if (root == null)
            return;
        Helper(root.left, temp);
        temp[0].left = null;
        temp[0].right = root;
        temp[0] = root;
        Helper(root.right, temp);
    }

}
