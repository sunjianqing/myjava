package com.jianqing.interview.leetcode18;

import com.jianqing.interview.base.ListNode;

public class lc_328 {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p1 != null && p2 != null) {
            p1.next = p2.next;
            p1 = p2.next;
            if(p1 != null){
                p2.next = p1.next;
                p2 = p1.next;
            }
        }

        while(oddHead.next != null ) {
            oddHead = oddHead.next;
        }

        oddHead.next = evenHead;

        return head;
    }

}
