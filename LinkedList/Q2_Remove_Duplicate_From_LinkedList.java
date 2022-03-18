package LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:09/03/2022
 ?Program Details:82. Remove Duplicates from Sorted List II
*https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/ 
   */
public class Q2_Remove_Duplicate_From_LinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();

        ListNode temp = dummy, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            int count = 0;
            while (next != null && next.val == curr.val) {
                count++;
                next = next.next;
            }
            if (count == 0) {
                temp.next = curr;
                temp = temp.next;
            }
            curr = next;
        }
        return dummy.next;
    }
}
