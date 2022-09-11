package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 !Name: Aritra Ghorai
 !Date:05/09/2022
 ?Program Details:429. N-ary Tree Level Order Traversal
 *https://leetcode.com/problems/n-ary-tree-level-order-traversal/
   */
public class Q10_Narray_Tree_Traversal {
    private class Node {
        public int val;
        public List<Node> children;

        // public Node() {
        // }

        // public Node(int _val) {
        // val = _val;
        // }

        // public Node(int _val, List<Node> _children) {
        // val = _val;
        // children = _children;
        // }
    };

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Node> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int si = qu.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < si; i++) {
                var rn = qu.poll();
                temp.add(rn.val);
                for (var ch : rn.children) {
                    if (ch != null)
                        qu.offer(ch);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
