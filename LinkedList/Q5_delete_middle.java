package LinkedList;

/*
    !Name: Aritra Ghorai
    !Date:14/10/2022
    ?Program Details:2095. Delete the Middle Node of a Linked List
    *https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
*/
public class Q5_delete_middle {
  public ListNode deleteMiddle(ListNode head) {
    int size = 0;
    ListNode temp = head;
    while (temp != null) {
      temp = temp.next;
      size++;
    }

  }
}
