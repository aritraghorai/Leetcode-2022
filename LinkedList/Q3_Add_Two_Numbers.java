package LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:10/03/2022
 ?Program Details:2. Add Two Numbers
 *https://leetcode.com/problems/add-two-numbers/ 
   */
public class Q3_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2;
        int value = 0;
        boolean greterThanTen = false;
        ListNode res = new ListNode();
        ListNode resTemp = res, prev = null;
        while (temp1 != null && temp2 != null) {
            value = temp1.val + temp2.val;
            if (greterThanTen) {
                value++;
                greterThanTen = false;
            }
            if (value > 9) {
                value %= 10;
                greterThanTen = true;
                resTemp.val = value;
            } else {
                resTemp.val = value;
            }
            resTemp.next = new ListNode();
            prev = resTemp;
            resTemp = resTemp.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while (temp1 != null) {
            if (greterThanTen) {
                value = temp1.val + 1;
                greterThanTen = false;
            } else {
                value = temp1.val;
            }
            if (value > 9) {
                value %= 10;
                greterThanTen = true;
                resTemp.val = value;
            } else {
                resTemp.val = value;
            }
            resTemp.next = new ListNode();
            prev = resTemp;
            resTemp = resTemp.next;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            if (greterThanTen) {
                value = temp2.val + 1;
                greterThanTen = false;
            } else {
                value = temp2.val;
            }
            if (value > 9) {
                value %= 10;
                greterThanTen = true;
                resTemp.val = value;
            } else {
                resTemp.val = value;
            }
            resTemp.next = new ListNode();
            prev = resTemp;
            resTemp = resTemp.next;
            temp2 = temp2.next;
        }
        if (greterThanTen) {
            resTemp.val = 1;
        } else {
            prev.next = null;
        }
        return res;
    }
}
