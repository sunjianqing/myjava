package com.jianqing.interview.leetcode;

import com.jianqing.interview.base.ListNode;

/**
 * Created by jianqsun on 5/20/14.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return null;
        }
        else{
            int i = 1;
            ListNode tmpNode = new ListNode(0);
            tmpNode.next = head;
            ListNode startNode = head.next;
            while(i<m){
                tmpNode = tmpNode.next;
                startNode = startNode.next;
                i++;
            }

            ListNode p2 = startNode.next;
            ListNode p1 = startNode;
            while(m<n){
                ListNode p3 = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = p3;
                m++;
            }
            tmpNode.next.next = p2.next;
            tmpNode.next = p2;
            return head;
        }
    }
}
