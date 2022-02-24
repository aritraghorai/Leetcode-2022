package LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:24/02/2022
 ?Program Details:148. Sort List
 *https://leetcode.com/problems/sort-list/
   */
public class Q1_Sort_List {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);

    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dNode = new ListNode(0), temp = dNode;
        while (left != null && right != null) {
            if (left.val > right.val) {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            } else {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }
        }
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return dNode.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
