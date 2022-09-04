package BinaryTree;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:04/09/2022
 ?Program Details: 987. Vertical Order Traversal of a Binary Tree
*https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
   */
public class Q9_Verticle_Order_Traversal_Binary_Tree {
    private class vertical_Pair implements Comparable<vertical_Pair> {
        TreeNode node;
        int col;
        int row;

        vertical_Pair(TreeNode n, int r, int c) {
            node = n;
            row = r;
            col = c;
        }

        @Override
        public int compareTo(vertical_Pair o) {
            if (col != o.col)
                return col - o.col;
            if (row != o.row) {
                return row - o.row;
            }
            return node.val - o.node.val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<vertical_Pair> pq = new PriorityQueue<>();
        LinkedList<vertical_Pair> qu = new LinkedList<>();
        qu.offer(new vertical_Pair(root, 0, 0));
        int low_Col = 0;
        int highCol = 0;
        while (!qu.isEmpty()) {
            int si = qu.size();
            for (int i = 0; i < si; i++) {
                var rp = qu.poll();
                pq.offer(rp);
                if (rp.node.left != null) {
                    qu.offer(new vertical_Pair(rp.node.left, rp.row + 1, rp.col - 1));
                    low_Col = Math.min(low_Col, rp.col - 1);
                }
                if (rp.node.right != null) {
                    qu.offer(new vertical_Pair(rp.node.right, rp.row + 1, rp.col + 1));
                    highCol = Math.max(rp.col + 1, highCol);
                }
            }
        }
        int resSize = highCol - low_Col + 1;
        for (int i = 0; i < resSize; i++) {
            res.add(new ArrayList<>());
        }
        while (!pq.isEmpty()) {
            var pair = pq.poll();
            res.get(-low_Col + pair.col).add(pair.node.val);
        }
        return res;
    }

}
