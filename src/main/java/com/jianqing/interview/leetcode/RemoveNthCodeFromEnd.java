package com.jianqing.interview.leetcode;

import com.jianqing.interview.base.ListNode;

/**
 * Created by jianqsun on 5/21/14.
 */
public class RemoveNthCodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        ListNode predecessor = new ListNode(0);
        predecessor.next = head;
        ListNode p2 = head;
        ListNode p1 = head;
        int m = n;
        while(n>0){
            p2 = p2.next;
            n--;
            if(n>0 && p2 == null){
                return predecessor.next;
            }
        }
        
        if(p2 == null){
            predecessor.next = p1.next;
        }else{
            while(p2.next != null){
                p1 = p1.next;
                p2 = p2.next;
            }
            p1.next = p1.next.next;
        }

        return predecessor.next;
    }
}
