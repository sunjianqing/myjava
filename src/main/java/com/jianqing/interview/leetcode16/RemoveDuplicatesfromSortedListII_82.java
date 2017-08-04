package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.ListNode;

/**
 * Created by jianqingsun on 5/12/17.
 */
public class RemoveDuplicatesfromSortedListII_82 {

    public ListNode deleteDuplicates(ListNode head) {


        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);

        ListNode p0 = dummy;
        p0.next = head;
        ListNode p1 = p0.next;
        ListNode p2 = p1.next;

        while (p2 != null) {
            if (p1.val != p2.val) {
                p0.next = p1;
                p0 = p1;
                p1 = p2;
                p2 = p1.next;
            } else {
                while (p2 != null && p2.val == p1.val) {
                    p2 = p2.next;
                }

                p1 = p2;
                if (p1 != null)
                    p2 = p1.next;
            }
        }

        p0.next = p1;

        return dummy.next;

    }

    // 简单点儿
    public ListNode cleanCode(ListNode head) {
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;    //while loop to find the last node of the dups.
            }
            if (slow.next != fast) { //duplicates detected.
                slow.next = fast.next; //remove the dups.
                fast = slow.next;     //reposition the fast pointer.
            } else { //no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }

        }
        return dummy.next;
    }
}
