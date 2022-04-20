package Binary_Search_Tree;

/*
 !Name: Aritra Ghorai
 !Date:20/04/2022
 ?Program Details:173. Binary Search Tree Iterator
 *https://leetcode.com/problems/binary-search-tree-iterator/
   */
public class Q5_Implement_Itarator_In_BST {

}

class BSTIterator {
    TreeNode root;
    TreeNode current = root;
    TreeNode temp = null;

    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    public int next() {
        int val = 0;
        while (current != null) {
            if (current.left == null) {
                val = current.val;
                current = current.right;
                break;
            } else {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = current;
                    current = current.left;
                }
                if (temp.right == current) {
                    temp.right = null;
                    val = current.val;
                    current = current.right;
                    break;
                }
            }
        }
        return val;
    }

    public boolean hasNext() {
        return current != null;
    }

}
