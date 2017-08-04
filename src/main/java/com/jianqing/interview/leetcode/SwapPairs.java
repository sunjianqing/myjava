package com.jianqing.interview.leetcode;

import com.jianqing.interview.base.ListNode;

/**
 * Created by jianqsun on 5/15/14.
 *
 * Passed
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head){
        ListNode finalHead = new ListNode(0);
        ListNode pre = new ListNode(0);
        pre.next = head;

        if(head == null){
            return null;
        }

        //注意保存头指针
        if(head.next == null){
            finalHead.next = head;
        }
        else{
            finalHead.next = head.next;
        }

        while(head != null && head.next !=null){
            ListNode tmp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = tmp;
            pre = head;
            head = tmp;
        }

        return finalHead.next;
    }
}
