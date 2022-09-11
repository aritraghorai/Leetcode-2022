package BinaryTree;

/*
 !Name: Aritra Ghorai
 !Date:07/09/2022
 ?Program Details:606. Construct String from Binary Tree
 *https://leetcode.com/problems/construct-string-from-binary-tree/
   */
public class Q11_Construct_Tree_From_Binary_Tree {
    private StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode root) {
        f(root);
        return sb.toString();
    }

    private void f(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            return;
        }
        sb.append(root.val);
        sb.append("(");
        f(root.left);
        sb.append(")");
        if (root.right != null) {
            sb.append("(");
            f(root.right);
            sb.append(")");
        }
    }
}
