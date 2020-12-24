package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.ListNode;

/**
 * Merge sort 思想
 *
 */
public class LC_148_SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;

        ListNode mid = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = slow;
            slow = slow.next;
        }

        // 断开
        mid.next = null;

        ListNode left = sortList(dummy.next);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next; // 这个别忘了
        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;


    }


}
