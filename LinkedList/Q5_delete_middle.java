package LinkedList;

/*
    !Name: Aritra Ghorai
    !Date:14/10/2022
    ?Program Details:2095. Delete the Middle Node of a Linked List
    *https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
*/
public class Q5_delete_middle {
  public ListNode deleteMiddle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    int size = 0;
    ListNode temp = head;
    while (temp != null) {
      temp = temp.next;
      size++;
    }
    int mid = size / 2;
    temp = head;
    for (int i = 1; i < mid; i++) {
      temp = temp.next;
    }
    temp.next = temp.next.next;
    return head;
  }
}
