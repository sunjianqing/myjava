package com.jianqing.interview.leetcode16;


import com.jianqing.interview.base.ListNode;

/**
 * Created by jianqingsun on 12/7/16.
 */
public class SwapNodesinPairs implements Solution {
    @Override
    public void solution() {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p1 = dummy;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            ListNode nextstart = p2.next.next; //step 1 ， 保留新的起点
            p2.next.next = p2;  //step 2 , 可以更改 p2.next.next
            p1.next = p2.next;  // step 3 , p1.next 可以改了
            p2.next = nextstart; // step 4, p2。next 可以改了
            p1 = p2;
            p2 = p2.next;
        }

        return dummy.next;
    }
}
