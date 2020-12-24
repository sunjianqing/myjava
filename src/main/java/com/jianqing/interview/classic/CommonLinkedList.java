package com.jianqing.interview.classic;

import com.jianqing.interview.base.ListNode;

public class CommonLinkedList {

    /**
     * Find middle element
     * 定义快慢指针
     *
     */
    public ListNode findMiddle(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        //如果要断开， 就
        pre.next = null;
        return slow;
    }
}
