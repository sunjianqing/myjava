package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.ListNode;

/**
 * Created by jianqingsun on 11/29/16.
 */
public class ReverseLinkedList_206 implements Solution {
    @Override
    public void solution() {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode p1 = null;
        ListNode p2 = head;
        ListNode tmp;

        while (p2 != null) {
            tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }

        return p1;
    }
}
