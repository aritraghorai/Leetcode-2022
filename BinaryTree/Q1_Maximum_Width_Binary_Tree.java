package BinaryTree;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:27/02/2022
 ?Program Details:662. Maximum Width of Binary Tree
 *https://leetcode.com/problems/maximum-width-of-binary-tree/
   */
public class Q1_Maximum_Width_Binary_Tree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        var qu = new LinkedList<Pair>();
        qu.add(new Pair(root, 0));
        int maxWidth = 1;
        while (!qu.isEmpty()) {
            int size = qu.size();
            int lindex = qu.peekLast().index;
            int fristIndex = qu.peekFirst().index;
            System.out.println(fristIndex + " " + lindex);
            while (size-- > 0) {
                var rn = qu.poll();

                if (rn.node.left != null)
                    qu.offer(new Pair(rn.node.left, 2 * rn.index + 1));
                if (rn.node.right != null)
                    qu.offer(new Pair(rn.node.right, 2 * rn.index + 2));
            }
            maxWidth = Math.max(maxWidth, lindex - fristIndex + 1);
        }
        return maxWidth;

    }
}

class Pair {
    TreeNode node;
    int index = 0;

    Pair(TreeNode n, int i) {
        node = n;
        index = i;
    }
}
