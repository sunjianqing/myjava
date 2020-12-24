package com.jianqing.interview.facebook.lc20;

/**
 * Odd Even Linked List
 */

import com.jianqing.interview.base.ListNode;

public class LC_328_OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oHead = head;
        ListNode eHead = head.next;

        ListNode odd = head;
        ListNode even = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = eHead;

        return oHead;
    }
}
