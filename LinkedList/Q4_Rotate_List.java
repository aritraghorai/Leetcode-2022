package LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:11/03/2022
 ?Program Details:61. Rotate List
 *https://leetcode.com/problems/rotate-list/ 
   */
public class Q4_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int length = 0;
        ListNode temp1 = head;
        while (head != null) {
            length++;
            temp1 = temp1.next;
        }
        k = k % length;
        ListNode rotateHead = rotate(head);
        ListNode temp = rotateHead;
        for (int i = 1; i < k; i++) {
            temp = temp.next;
        }
        ListNode nextPart = temp.next;
        temp.next = null;
        ListNode newHead = rotate(rotateHead);
        ListNode newPart = rotate(nextPart);
        rotateHead.next = newPart;
        return newHead;
    }

    public ListNode rotate(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, curr = head, next = head;
        while (next != null) {
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        return curr;
    }
}
