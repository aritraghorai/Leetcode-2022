package BinaryTree;

/*
 !Name: Aritra Ghorai
 !Date:13/05/2022
 ?Program Details:117. Populating Next Right Pointers in Each Node II
 *https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
   */
public class Q4_Propulating_Next_Pointer_Each_Right_Node {
    public Node connect(Node root) {
        Node temp1 = root;
        Node temp2 = null;
        Node newHead = null;
        while (temp1 != null) {
            while (temp1 != null) {
                if (temp1.left != null) {
                    if (temp2 == null) {
                        newHead = temp1.left;
                        temp2 = newHead;
                    } else {
                        temp2.next = temp1.left;
                        temp2 = temp2.next;
                    }
                }
                if (temp1.right != null) {
                    if (temp2 == null) {
                        newHead = temp1.right;
                        temp2 = newHead;
                    } else {
                        temp2.next = temp1.right;
                        temp2 = temp2.next;
                    }
                }
                temp1 = temp1.next;
            }
            temp1 = newHead;
            temp2 = null;
            newHead = null;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
