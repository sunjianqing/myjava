package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.ListNode;

/**
 * Created by jianqingsun on 8/17/17.
 */

/**
 * Reverse a link list between begin and end exclusively
 * an example:
 * a linked list:
 * 0->1->2->3->4->5->6
 * |           |
 * begin       end
 * after call begin = reverse(begin, end)
 *
 * 0->3->2->1->4->5->6
 *          |  |
 *      begin end
 * @return the reversed list's 'begin' node, which is the precedence of node end
 */

public class ReverseNodesinkGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode dummy = new ListNode(-1);

        dummy.next = head;
        ListNode begin = null;
        begin = dummy;

        int i = 0;
        while (head != null) {
            i++;

            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            }
            else{
                head = head.next;
            }

        }

        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode pre = begin;

        first = curr;
        while(curr != end) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        begin.next = pre;
        first.next = curr; // 这个需注意
        return first;
    }
}
