package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.ListNode;

/**
 * Created by jianqingsun on 4/20/17.
 */
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null )
            return null;

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null && p1 != p2 ) {
            p1 = p1.next;

            if(p2.next != null && p2.next.next != null ){
                p2  = p2.next.next;
            }
            else
                p2 = null;
        }

        if(p2 == null)
            return null;


        // p1 继续走， 另一个从head 走， 走到相遇 就是交点
        ListNode p0 = new ListNode(0);
        p0.next = head;
        while(p0 != p1) {
            p0 = p0.next;
            p1 = p1.next;
        }

        return p1;
    }
}
