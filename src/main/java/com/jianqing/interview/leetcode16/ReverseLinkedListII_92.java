package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.ListNode;

/**
 * Created by jianqing_sun on 4/24/17.
 */
public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null || head.next == null) {
            return head;
        }

        ListNode preStart = new ListNode(0);
        preStart.next = head;

        int i = 1 ;
        while(i < m){
            preStart = preStart.next;
            i++;
        }

        ListNode p1 = preStart.next;
        ListNode p2 = p1.next;

        while(i < n){
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
            i++;
        }

        preStart.next.next = p2;
        preStart.next = p1;

        return m == 1 ? preStart.next : head;
    }

    // 牛逼， 简单
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }
}
